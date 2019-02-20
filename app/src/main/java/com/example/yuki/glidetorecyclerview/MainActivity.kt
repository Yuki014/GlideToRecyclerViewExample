package com.example.yuki.glidetorecyclerview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toRecyclerLayoutBtn = findViewById<Button>(R.id.toRecyclerLayoutBtn)
        toRecyclerLayoutBtn!!.setOnClickListener {
            //MainActivity.thisと書くと強参照のためOutOfMemoryが発生する可能性があるのでApplicationにする
            val intent = Intent(application, RecyclerViewLayout::class.java)
            startActivity(intent)
        }
    }
}
