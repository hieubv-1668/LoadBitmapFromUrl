package bvh.demo.loadbitmapfromurl.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bvh.demo.loadbitmapfromurl.R
import bvh.demo.loadbitmapfromurl.data.ImageModel
import kotlinx.android.synthetic.main.item_image.view.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class ImageAdapter(
    private val lifecycleScope: LifecycleCoroutineScope,
    private val exceptionHandler: CoroutineExceptionHandler,
    private val memoryCache: LruCache<String, Bitmap>
) : ListAdapter<ImageModel, ImageAdapter.Companion.ImageViewHolder>(
    ImageDiffCallback()
) {
    class ImageDiffCallback : DiffUtil.ItemCallback<ImageModel>() {
        override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ImageViewHolder(
            inflater.inflate(
                R.layout.item_image,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.itemView.imv_image_url.tag = getItem(position).id
        holder.bind(getItem(position), lifecycleScope, exceptionHandler, memoryCache)
    }

    companion object {
        class ImageViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            fun bind(
                imageModel: ImageModel,
                lifecycleScope: LifecycleCoroutineScope,
                exceptionHandler: CoroutineExceptionHandler,
                memoryCache: LruCache<String, Bitmap>
            ) {
                itemView.imv_image_url.setImageBitmap(null)
                setImageBitmap(
                    imageModel,
                    itemView.imv_image_url,
                    lifecycleScope,
                    exceptionHandler,
                    memoryCache
                )
            }

            private fun setImageBitmap(
                imageModel: ImageModel,
                imageView: ImageView,
                lifecycleScope: LifecycleCoroutineScope,
                exceptionHandler: CoroutineExceptionHandler,
                memoryCache: LruCache<String, Bitmap>
            ) {
                lifecycleScope.launch(Dispatchers.IO + exceptionHandler) {
                    val bitmapImage = BitmapFactory.decodeStream(URL(imageModel.url).openStream())
                    synchronized(memoryCache) {
                        if (memoryCache.get(imageModel.url) == null) {
                            memoryCache.put(imageModel.url, bitmapImage)
                        }
                    }
                    if (imageView.tag == imageModel.id) {
                        launch(Dispatchers.Main) {
                            imageView.setImageBitmap(memoryCache.get(imageModel.url))
                        }
                    }
                }
            }
        }
    }
}
