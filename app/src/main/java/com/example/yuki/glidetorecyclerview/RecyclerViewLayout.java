package com.example.yuki.glidetorecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewLayout extends AppCompatActivity {
    private List<String> imageUrlList = new ArrayList<String>() {
        {
            add( "https://1.bp.blogspot.com/-zjDTZDFCBK4/XAY52PvgJQI/AAAAAAABQfc/2KrTzNnPhJQLHcP7mlbn2bfpLYjg3OPTQCLcBGAs/s400/food_thai_rukutin.png");
            add("https://3.bp.blogspot.com/-jWRV4wydKok/XAY51kXmAwI/AAAAAAABQfY/vboPJ0Mx6Nkjyg9aNxvHQjIMmuBYF8EIgCLcBGAs/s400/food_thai_pattai.png");
            add("https://3.bp.blogspot.com/-EThXiq-hPSw/XAY51fOoptI/AAAAAAABQfU/PQDuIj9y23cs9X-wnEWNSHKwhn6KhXoGwCLcBGAs/s400/food_thai_kaiparo.png");
            add("https://4.bp.blogspot.com/-IVtMnCZlJ0c/XAY50lrs6II/AAAAAAABQfM/WDlEdj10XcYuSSTou9R4LbSIgc1iR29_QCLcBGAs/s400/food_maguro_steak.png");
            add("https://4.bp.blogspot.com/-uOa1ZQ76lGY/XAY5z6uRfyI/AAAAAAABQfI/7ZToFKcJXL8Eybuik_7nLykFf3PxaIUsgCLcBGAs/s400/food_anchovy_olive_oil.png");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView RecyclerView = findViewById(R.id.RecyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(createDataset(), this);
        //LayoutManagerをセット(ここをgridLayoutManagerに変えると横に並べたりもできる)
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(layoutManager);
        //adapterをセット
        RecyclerView.setAdapter(recyclerViewAdapter);
    }

    //適当に表示するためのデータセットを作成する
    private List<RecyclerViewBean> createDataset() {
        List<RecyclerViewBean> recyclerViewBeans = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            RecyclerViewBean recyclerViewBean = new RecyclerViewBean();
            recyclerViewBean.setBodyTxt("美味しそうな画像だな～" + String.valueOf(i));
            recyclerViewBean.setImageUrl(imageUrlList.get(i % 5));

            recyclerViewBeans.add(recyclerViewBean);
        }

        return recyclerViewBeans;
    }
}
