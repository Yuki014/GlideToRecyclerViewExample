package com.example.yuki.glidetorecyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

class RecyclerViewAdapter(private val list: List<RecyclerViewBean>, private val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    private val imageWidth = 96
    private val imageHeight = 96

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflateView = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false)
        return RecyclerViewHolder(inflateView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bodyTxt.text = list[position].bodyTxt
        //error:読み込み失敗時に読み込む画像のURLを指定
        //placeholder:読み込み開始時に読み込む画像のURLを指定
        //override:読み込む画像サイズを指定
        val options = RequestOptions().error(R.drawable.baseline_assignment_late_24).placeholder(R.drawable.baseline_autorenew_24).override(imageWidth, imageHeight)
        //load:読み込む画像のURLを指定

        Glide.with(context).load(list[position].imageUrl).listener(object : RequestListener<Drawable> {
            //画像の読み込み失敗時の処理
            override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
                e?.printStackTrace()
                return false
            }

            //読み込み完了して表示する直前の処理
            override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                return false
            }
            //apply:RequestOptionsで指定したオプションを適用
            //into:画像をセットするImageViewを指定
        }).apply(options).into(holder.iconImageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onViewRecycled(viewHolder: RecyclerViewHolder) {
        Glide.with(context).clear(viewHolder.iconImageView)
    }

    inner class RecyclerViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iconImageView: ImageView
        var bodyTxt: TextView

        init {
            iconImageView = itemView.findViewById(R.id.iconImageView)
            bodyTxt = itemView.findViewById(R.id.bodyTxt)
        }
    }
}
