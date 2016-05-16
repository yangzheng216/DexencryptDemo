package com.example.dexencryptdemo.encrypt;

import android.content.Context;
import android.widget.Toast;

import com.example.dexencryptdemo.*;

/**
 * 
 *
 */
public class IClass implements Iinterface {

	private Context context;

	public IClass(Context context) {
		super();
		this.context = context;
	}

	@Override
	public void call() {
		Toast.makeText(context, "call method", Toast.LENGTH_SHORT).show();
	}

	@Override
	public String getData() {
		return "hello, IClass";
	}

}
