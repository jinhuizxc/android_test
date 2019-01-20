package com.jh.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment4 extends Fragment {

	private TextView tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment2, container, false);
		TextView tv = (TextView) view.findViewById(R.id.text);
		tv.setText("第二个Fragment");
		Log.i("Main", "Fragment2---onCreateView()");
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.i("Main", "Fragment2---onAttach()");

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("Main", "Fragment2---onCreate()");

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i("Main", "Fragment2---onActivityCreated()");

	}

	@Override
	public void onStart() {
		super.onStart();
		Log.i("Main", "Fragment2---onStart()");

	}

	@Override
	public void onResume() {
		super.onResume();
		Log.i("Main", "Fragment2---onResume()");

	}

	@Override
	public void onPause() {
		super.onPause();
		Log.i("Main", "Fragment2---onPause()");

	}

	@Override
	public void onStop() {
		super.onStop();
		Log.i("Main", "Fragment2---onStop()");

	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.i("Main", "Fragment2---onDestroyView()");

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("Main", "Fragment2---onDestroy()");

	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.i("Main", "Fragment2---onDetach()");
	}
}
