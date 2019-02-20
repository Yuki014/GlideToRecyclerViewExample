package com.example.yuki.glidetorecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.bumptech.glide.Glide

import java.util.ArrayList

class RecyclerViewLayout : AppCompatActivity() {
    private val imageUrlList = object : ArrayList<String>() {
        init {
            add("https://1.bp.blogspot.com/-zjDTZDFCBK4/XAY52PvgJQI/AAAAAAABQfc/2KrTzNnPhJQLHcP7mlbn2bfpLYjg3OPTQCLcBGAs/s400/food_thai_rukutin.png")
            add("https://3.bp.blogspot.com/-jWRV4wydKok/XAY51kXmAwI/AAAAAAABQfY/vboPJ0Mx6Nkjyg9aNxvHQjIMmuBYF8EIgCLcBGAs/s400/food_thai_pattai.png")
            add("https://3.bp.blogspot.com/-EThXiq-hPSw/XAY51fOoptI/AAAAAAABQfU/PQDuIj9y23cs9X-wnEWNSHKwhn6KhXoGwCLcBGAs/s400/food_thai_kaiparo.png")
            add("https://4.bp.blogspot.com/-IVtMnCZlJ0c/XAY50lrs6II/AAAAAAABQfM/WDlEdj10XcYuSSTou9R4LbSIgc1iR29_QCLcBGAs/s400/food_maguro_steak.png")
            add("https://4.bp.blogspot.com/-uOa1ZQ76lGY/XAY5z6uRfyI/AAAAAAABQfI/7ZToFKcJXL8Eybuik_7nLykFf3PxaIUsgCLcBGAs/s400/food_anchovy_olive_oil.png")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        val recyclerViewAdapter = RecyclerViewAdapter(createDataset(), this)
        //LayoutManagerをセット(ここをgridLayoutManagerに変えると横に並べたりもできる)
        //val layoutManager = GridLayoutManager(this, 2)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        //adapterをセット
        recyclerView.adapter = recyclerViewAdapter
    }

    //適当に表示するためのデータセットを作成する
    private fun createDataset(): List<RecyclerViewBean> {
        val recyclerViewBeans = ArrayList<RecyclerViewBean>()

        for (i in 0..2000) {
            val recyclerViewBean = RecyclerViewBean()
            recyclerViewBean.bodyTxt = "美味しそうな画像だな～$i"
            recyclerViewBean.imageUrl = imageUrlList[i % 5]

            recyclerViewBeans.add(recyclerViewBean)
        }

        return recyclerViewBeans
    }

    override fun finish() {
        super.finish()
        Glide.with(this).pauseRequests()
    }
}
