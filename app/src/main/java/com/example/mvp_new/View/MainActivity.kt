package com.example.mvp_new.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp_new.Adapter.AdapterBerita
import com.example.mvp_new.Model.GetDataBeritaResponseItem
import com.example.mvp_new.Presenter.NewsInterce
import com.example.mvp_new.Presenter.NewsPresnter
import com.example.mvp_new.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsInterce {

    private lateinit var presenternews : NewsPresnter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenternews = NewsPresnter(this)
        presenternews.getDataNews()
    }

    override fun onSuccess(pesan: String, news: List<GetDataBeritaResponseItem>) {
        rv_berita.layoutManager = LinearLayoutManager(this)
        rv_berita.adapter =AdapterBerita(news)
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
    }
}