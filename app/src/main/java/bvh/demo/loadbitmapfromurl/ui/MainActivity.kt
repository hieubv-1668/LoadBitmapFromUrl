package bvh.demo.loadbitmapfromurl.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import bvh.demo.loadbitmapfromurl.R
import bvh.demo.loadbitmapfromurl.data.ImageModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineExceptionHandler

class MainActivity : AppCompatActivity() {
    private lateinit var imageAdapter: ImageAdapter

    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("CoroutineExeption", exception.message.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        imageAdapter = ImageAdapter(lifecycleScope, handler)
        imageAdapter.submitList(getData())
        rv_image.adapter = imageAdapter
    }

    private fun getData() = listOf(
        ImageModel(
            1,
            "https://c4.wallpaperflare.com/wallpaper/617/224/944/5bd3503c61ef4-wallpaper-preview.jpg"
        ),
        ImageModel(
            2,
            "https://www.konsultasi-akustik.com/wp-content/uploads/2020/01/landscape-nature-wilderness-view-68147.jpg"
        ),
        ImageModel(
            3,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvvddt7UGT-uBReUtgxYlwwpP63rv23YEsPWmjKzrjhTi4dWM&s"
        ),
        ImageModel(
            4,
            "https://cdn.statically.io/img/thewallpaper.co//wp-content/uploads/2016/10/hd-nature-wallpapers-high-definition-cool-free-beautiful-nature-full-hd-1080p-hd-windows-10-desktop-images-1920x1080.jpg"
        ),
        ImageModel(
            5,
            "https://3.bp.blogspot.com/-I4xUN1vvA5s/UA-orEqxqeI/AAAAAAAABcw/YXZXaDcY0Nw/s1600/Superb%2BBest%2BNatural%2BWallpapers%2BHD-700426.jpg"
        ),
        ImageModel(
            6,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxCUtJ9OHGDtOdnL5QXPtwuI95bPdrTar8jJ4yrLww64WdPKHh&s"
        ),
        ImageModel(
            7,
            "https://i.pinimg.com/originals/98/49/9e/98499efd80584fe9a59a04eac21051c7.jpg"
        ),
        ImageModel(
            8,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8aT1T3nqSDACpgmzvmDX8BX9eXULp1Txj51Rvh3_voWHDJVQ&s    "
        ),
        ImageModel(
            9,
            "https://i.pinimg.com/originals/e1/95/c6/e195c69227affe9c68db10bafc026964.jpg"
        ),
        ImageModel(
            10,
            "https://cdn.statically.io/img/thewallpaper.co//wp-content/uploads/2016/10/hd-nature-wallpapers-high-definition-cool-free-beautiful-nature-full-hd-1080p-hd-windows-10-desktop-images-1920x1080.jpg"
        ),
        ImageModel(
            11,
            "https://3.bp.blogspot.com/-I4xUN1vvA5s/UA-orEqxqeI/AAAAAAAABcw/YXZXaDcY0Nw/s1600/Superb%2BBest%2BNatural%2BWallpapers%2BHD-700426.jpg"
        ),
        ImageModel(
            12,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxCUtJ9OHGDtOdnL5QXPtwuI95bPdrTar8jJ4yrLww64WdPKHh&s"
        ),
        ImageModel(
            13,
            "https://i.pinimg.com/originals/98/49/9e/98499efd80584fe9a59a04eac21051c7.jpg"
        ),
        ImageModel(
            14,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8aT1T3nqSDACpgmzvmDX8BX9eXULp1Txj51Rvh3_voWHDJVQ&s    "
        ),
        ImageModel(
            15,
            "https://i.pinimg.com/originals/e1/95/c6/e195c69227affe9c68db10bafc026964.jpg"
        ),
        ImageModel(
            16,
            "https://cdn.statically.io/img/thewallpaper.co//wp-content/uploads/2016/10/hd-nature-wallpapers-high-definition-cool-free-beautiful-nature-full-hd-1080p-hd-windows-10-desktop-images-1920x1080.jpg"
        ),
        ImageModel(
            17,
            "https://3.bp.blogspot.com/-I4xUN1vvA5s/UA-orEqxqeI/AAAAAAAABcw/YXZXaDcY0Nw/s1600/Superb%2BBest%2BNatural%2BWallpapers%2BHD-700426.jpg"
        ),
        ImageModel(
            18,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8aT1T3nqSDACpgmzvmDX8BX9eXULp1Txj51Rvh3_voWHDJVQ&s    "
        ),
        ImageModel(
            19,
            "https://i.pinimg.com/originals/e1/95/c6/e195c69227affe9c68db10bafc026964.jpg"
        )
    )
}
