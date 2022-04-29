package com.example.mvp_new.Network

import com.example.mvp_new.Model.GetDataBeritaResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface EndPoind {
    @GET("news")
    fun getDataBerita(): Call<List<GetDataBeritaResponseItem>>
}