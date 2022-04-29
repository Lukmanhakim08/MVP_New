package com.example.mvp_new.Presenter

import com.example.mvp_new.Model.GetDataBeritaResponseItem

interface NewsInterce {
    fun onSuccess(pesan: String, news: List<GetDataBeritaResponseItem>)
    fun onError(pesan: String)
}