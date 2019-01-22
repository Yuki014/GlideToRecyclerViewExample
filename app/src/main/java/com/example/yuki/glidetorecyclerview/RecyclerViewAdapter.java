package com.example.yuki.glidetorecyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private final int imageWidth = 96;
    private final int imageHeight = 96;
    private List<RecyclerViewBean> list;
    private Context context;

    public RecyclerViewAdapter(List<RecyclerViewBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflateView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(inflateView);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bodyTxt.setText(list.get(position).getBodyTxt());
        //error:読み込み失敗時に読み込む画像のURLを指定
        //placeholder:読み込み開始時に読み込む画像のURLを指定
        //override:読み込む画像サイズを指定
        RequestOptions options = new RequestOptions().error(R.drawable.baseline_assignment_late_24).placeholder(R.drawable.baseline_autorenew_24).override(imageWidth, imageHeight);
        //load:読み込む画像のURLを指定
        Glide.with(context).load(list.get(position).getImageUrl()).listener(new RequestListener<Drawable>() {
            //画像の読み込み失敗時の処理
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                if (e != null) {
                    e.printStackTrace();
                }
                return false;
            }
            //読み込み完了して表示する直前の処理
            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
            //apply:RequestOptionsで指定したオプションを適用
            //into:画像をセットするImageViewを指定
        }).apply(options).into(holder.iconImageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onViewRecycled(final RecyclerViewHolder viewHolder) {
        Glide.with(context).clear(viewHolder.iconImageView);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconImageView;
        public TextView bodyTxt;

        private RecyclerViewHolder(View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            bodyTxt = itemView.findViewById(R.id.bodyTxt);
        }
    }
}
