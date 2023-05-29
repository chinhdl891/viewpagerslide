package com.example.pading3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.pading3.databinding.ActivityMainBinding
import java.lang.Math.abs

class MainActivity2 : AppCompatActivity() {
    private val imageAdapter = ImageAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        activityMainBinding.vpgMain.adapter = imageAdapter
        imageAdapter.setData(getData())
        // You need to retain one page on each side so that the next and previous items are visible
        activityMainBinding.vpgMain.offscreenPageLimit = 1

// Add a PageTransformer that translates the next and previous items horizontally
// towards the center of the screen, which makes them visible
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.25f * abs(position))
            // If you want a fading effect uncomment the next line:
            page.alpha = 0.25f + (1 - abs(position))
        }
        activityMainBinding.vpgMain.setPageTransformer(pageTransformer)

// The ItemDecoration gives the current (centered) item horizontal margin so that
// it doesn't occupy the whole screen width. Without it the items overlap
        val itemDecoration = HorizontalMarginItemDecoration(
            this, R.dimen.viewpager_current_item_horizontal_margin
        )
        activityMainBinding.vpgMain.addItemDecoration(itemDecoration)
    }

    private fun getData(): List<Int> {
        return listOf(
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
        )
    }
}