package com.jh.gallery;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ViewSwitcher.ViewFactory;
import android.os.Build;

/**
 * 使用Gallery 和 ImageSwitcher 制作图片浏览器 Gallery介绍 我们有时候在手机上或者PC上看到动态的图片，
 * 可以通过鼠标或者手指触摸来移动它，产生动态的图片滚动效果，还可以根据你的点击或者触摸来触发其他事件响应。
 * 同样的，在Android中也提供这种实现，这就是通过Gallery在UI上实现缩略图浏览器。
 * ------------------------- 谷歌已经将Gallery列为过期的控件，建议使用HorizonScrollView或者ViewPager。
 * ------------------------- 查看源码不难发现 ArrayAdapter 和 SimpleAdapter 都继承了 BaseAdapter。
 * 所以，我们也可以自己定义一个适配器！自定义的好处是自由度、灵活性会更大。
 * <p>
 * BaseAdapter中的重要方法 (1)public int getCount()——返回一定义的数据源的总数量
 * (2)public Object getItem(int position) public long getItemId(int position)
 * ——告诉适配器取得目前容器中的数据ID和对象
 * (3)public View getView(int position,View convertView,ViewGroupparent)——取得目前要显示的图像View，
 * 传入数组ID值使之读取与成像。
 * <p>
 * -----------------------------------
 * <p>
 * 使用 Gallery 浏览图片的步骤： 1. 在 main.xml 中添加 Gallery标签。
 * 2. 在 MainActivity 中创建数据源，这里就是 int数组存放图片id。
 * 3. 自定义适配器。创建一个新类 ImageAdapter ，继承 BaseAdapter。
 * 重写getView(int position, View view, ViewGroup viewGroup)方法。
 * 4. 在 MainActivity加载适配器。
 */
public class MainActivity extends Activity implements OnItemSelectedListener, ViewFactory {

    // 准备数据源
    private int[] res = {R.drawable.item1, R.drawable.item2, R.drawable.item3,
            R.drawable.item4, R.drawable.item5, R.drawable.item6,
            R.drawable.item7, R.drawable.item8, R.drawable.item9,
            R.drawable.item10, R.drawable.item11, R.drawable.item12};

    private ImageAdapter adapter;
    private Gallery gallery;
    private ImageSwitcher is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        gallery = (Gallery) findViewById(R.id.gallery);
        is = (ImageSwitcher) findViewById(R.id.is);

        // gallery加载适配器
        adapter = new ImageAdapter(res, this);
        gallery.setAdapter(adapter);

        gallery.setOnItemSelectedListener(this);
        is.setFactory(this);
        is.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        is.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        //image.setBackgroundResource(res[position%res.length]);
        is.setBackgroundResource(res[position % res.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public View makeView() {
        ImageView image = new ImageView(this);
        image.setScaleType(ScaleType.FIT_CENTER);
        return image;
    }

}
