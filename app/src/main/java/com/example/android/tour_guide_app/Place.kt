package com.example.android.tour_guide_app

data class Place (val imageId: Int, val title: String,
                  val info: String, val longInfo:String, val openUntil: String,
                  val address: String, val addressLink: String, val average: String)