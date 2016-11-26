package cn.xm.libandroid.AndroidUtils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

public class NotificationService extends Service {
	private static NotificationService instance;
	private NotificationManager notificationManager;
	
	private NotificationService(Context context){
		notificationManager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
	}
	
	public static NotificationService getInstance(){
		if (instance==null) {
			instance=new NotificationService(context);
		}
		return instance;
	}
	// <<===============================>>
	/**
	 * 发出状态栏通知
	 * @param id Notification实例的唯一标识id
	 * @param notification Notification实例
	 */
	 public void notify(int id, Notification notification){
		 notificationManager.notify(id, notification);
	 }
	 
	 /**
	  * 清除
	  * @param id Notification实例的唯一标识id
	  */
	 public void cancel(int id){
		 notificationManager.cancel(id);
	 }
	 
	 public void cancelAll(){
		 notificationManager.cancelAll();
	 }
}
