package cn.xm.libandroid.AndroidUtils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class PackageService extends Service {
	private static PackageService instance; 
	private PackageManager packageManager;
	private ApplicationInfo metaDataInfo;
	private PackageInfo packageInfo;
	
	private PackageService(Context context) {
		packageManager = (PackageManager) context.getPackageManager();
		try {
			packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
			metaDataInfo = packageManager.getApplicationInfo(getPackageName(),PackageManager.GET_META_DATA);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static PackageService getInstance() {
		if (instance == null) {
			instance = new PackageService(context);
		}
		return instance;
	}
	// <<===============================>>
	
	/**
	 * 版本号，可以显示给用户
	 * 
	 * @param context
	 * @return
	 */
	public String getVersionName() {
		if (packageInfo != null) {
			return packageInfo.versionName;
		}
		return "";
	}

	/**
	 * 主要是版本升级所用，只要判断该值就能确定是否需要升级，不显示给用户
	 * 
	 * @param context
	 * @return
	 */
	public int getVersionCode() {
		if (packageInfo != null) {
			return packageInfo.versionCode;
		}
		return -1;
	}
	
	/** 获取 包名 */
	public  String getPackageName() {
		return context.getPackageName();
	}
	
	public ApplicationInfo getMetaDataInfo() {
		return metaDataInfo;
	}
}
