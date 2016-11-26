package cn.xm.libandroid.AndroidUtils;

import android.content.Context;

public class Service {
	protected static Context context;
	
	public static void init(Context context) {
		Service.context = context;
	}
}
