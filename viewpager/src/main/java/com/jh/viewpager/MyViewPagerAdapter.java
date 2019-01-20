package com.jh.viewpager;

import java.util.List;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * PagerAdapter常用方法：
 *  1.getCount() ---需要返回所有页卡的数量
 *  2.isViewFromObject（View
 * view，Object object） ---判断视图是否由对象产生
 * 3.instantiateItem(View Group container,int position) ---实例化界面
 * 4.destroyItem（ViewGroup container，intposition，Object object） ---销毁界面
 * 5.getPageTitle（int position） ---返回頁面标题信息 要想添加标题，
 *
 * 那么在 <android.support.v4.view.ViewPager>里添加子标签<android.support.v4.view.PagerTabStrip>或者<android.support.v4.view.PagerTitleStrip>
 */
public class MyViewPagerAdapter extends PagerAdapter {

    private List<View> viewList;
    private List<String> titleList;

    public MyViewPagerAdapter(List<View> viewList, List<String> titleList) {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    //返回所有视图的数量
    @Override
    public int getCount() {
        return viewList.size();
    }

    //判断视图是否由对象产生

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    //实例化页面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    //删除页面
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);  // 这行必须注释掉
        container.removeView(viewList.get(position));
    }


    /**
     * 设置ViewPager页面的title
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

}
