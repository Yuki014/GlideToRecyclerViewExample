package com.example.yuki.glidetorecyclerview;

//1行分のデータセットを保持するクラス
public class RecyclerViewBean {

    private String imageUrl;
    private String bodyTxt;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBodyTxt() {
        return bodyTxt;
    }

    public void setBodyTxt(String bodyTxt) {
        this.bodyTxt = bodyTxt;
    }
}
