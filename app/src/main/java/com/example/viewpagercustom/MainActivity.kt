package com.example.viewpagercustom

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter()
        viewPager.setPageTransformer(TransFormer())
        viewPager.adapter = adapter
    }
}

class TransFormer : ViewPager2.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        val img = view.findViewById<ImageView>(R.id.img)
        Log.d("position = ",position.toString() + view.toString())
        view.apply {
            val pageWidth = width
            when {
                position <= 0 -> { // [-1,0]
                    img.translationX = -position * pageWidth
                }
                position > 0 -> { // (0,1]
                    img.translationX = -position * pageWidth
                }
                else -> { // (1,+Infinity]
                }
            }
        }
    }
}