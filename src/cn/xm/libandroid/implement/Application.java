package cn.xm.libandroid.implement;

import android.app.Activity;
import cn.xm.libandroid.AndroidUtils.ActivityService;
import cn.xm.libandroid.AndroidUtils.AndroidSetting;
import cn.xm.libandroid.AndroidUtils.NotificationService;
import cn.xm.libandroid.AndroidUtils.PackageService;
import cn.xm.libandroid.AndroidUtils.PowerService;
import cn.xm.libandroid.AndroidUtils.WifiService;
import cn.xm.libandroid.AndroidUtils.no.ConnectivityService;
import cn.xm.libandroid.AndroidUtils.no.DirectoryService;

public class Application {
	public static Activity activity;
	
	/**初始化*/
	public static void initService(Activity activity) {
		WifiService.init(activity);
		PowerService.init(activity);
		AndroidSetting.init(activity);
		PackageService.init(activity);
		ActivityService.init(activity);
		DirectoryService.init(activity);
		ConnectivityService.init(activity);
		NotificationService.init(activity);
	}
}
