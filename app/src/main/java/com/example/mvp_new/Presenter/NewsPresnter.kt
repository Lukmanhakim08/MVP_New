package com.example.mvp_new.Presenter

import com.example.mvp_new.Model.GetDataBeritaResponseItem
import com.example.mvp_new.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPresnter(val viewnews : NewsInterce) {

    fun getDataNews(){
        ApiClient.instance.getDataBerita()
            .enqueue(object : Callback<List<GetDataBeritaResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetDataBeritaResponseItem>>,
                    response: Response<List<GetDataBeritaResponseItem>>
                ) {
                    if (response.isSuccessful){
                        viewnews.onSuccess(response.message(), response.body()!!)
                    }else{
                        viewnews.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetDataBeritaResponseItem>>, t: Throwable) {
                    viewnews.onError(t.message!!)
                }

            })
    }
}