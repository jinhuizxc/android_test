package com.jh.gallery;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * BaseAdapter中的重要方法
 * (1)public int getCount()——返回一定义的数据源的总数量
 * (2)public Object getItem(int position)
 * public long getItemId(int position) ——告诉适配器取得目前容器中的数据ID和对象
 * (3)public View getView(int position,View convertView,ViewGroupparent)
 * ——取得目前要显示的图像View，传入数组ID值使之读取与成像。
 */
public class ImageAdapter extends BaseAdapter {

    private int[] res;
    private Context context;

    public ImageAdapter(int[] res, Context context) {
        this.res = res;
        this.context = context;
    }

    //返回数据源的数量
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }


    @Override
    public Object getItem(int position) {
        return res[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     *  //  java.lang.ArrayIndexOutOfBoundsException: length=12; index=12
     *  解决方法:  image.setBackgroundResource(res[position % res.length]);
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("Main", "position=" + position + "res的角标=" + position % res.length);
        ImageView image = new ImageView(context);
        image.setBackgroundResource(res[position % res.length]);
        image.setLayoutParams(new Gallery.LayoutParams(400, 300));
        image.setScaleType(ScaleType.FIT_XY);
        return image;
    }


}
