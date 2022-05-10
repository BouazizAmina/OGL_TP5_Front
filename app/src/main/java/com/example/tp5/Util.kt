package com.example.tp5

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imgUrl:String) {
    Glide.with(context).load(url +imgUrl).into(this)
}