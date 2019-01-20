package com.jh.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragment2 extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		//layout布局文件转换成View对象

		/**
		 * resource:Fragment需要加载的布局文件
		 * root：加载layout的父ViewGroup
		 * attactToRoot：false，不返回父ViewGroup
		 */
		View view = inflater.inflate(R.layout.fragment, container, false);
		TextView text=(TextView) view.findViewById(R.id.text);
		text.setText("动态加载Fragment");
		Button button = view.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "测试", Toast.LENGTH_SHORT).show();
			}
		});
		return view;

	}

}
