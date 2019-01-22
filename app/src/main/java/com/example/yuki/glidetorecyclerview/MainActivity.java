package com.example.yuki.glidetorecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button toRecyclerLayoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toRecyclerLayoutBtn = findViewById(R.id.toRecyclerLayoutBtn);
        toRecyclerLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivity.thisと書くと強参照のためOutOfMemoryが発生する可能性があるのでgetApplication()にする
                Intent intent = new Intent(getApplication(), RecyclerViewLayout.class);
                startActivity(intent);
            }
        });
    }
}
