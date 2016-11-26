package cn.xm.libandroid.testcase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import cn.xm.libandroid.AndroidUtils.no.ConnectivityService;

/**
 * 测试 网络信号
 * @PS android.permission.ACCESS_NETWORK_STATE
 * @author yesunsong
 *
 */
public class ConnectivityServiceTest extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		builder.append("是否 有网络可连接:").append(ConnectivityService.getInstance().isNetworkAvaiable()).append("\n");
		builder.append("是否 WIFI可连接:").append(ConnectivityService.getInstance().isWifiAvaiable()).append("\n");
		builder.append("是否 Mobile可连接:").append(ConnectivityService.getInstance().isMobileAvaiable()).append("\n");
		
		builder.append("是否 有网络已连接:").append(ConnectivityService.getInstance().isNetworkConnected()).append("\n");
		builder.append("是否 有WIFI已连接:").append(ConnectivityService.getInstance().isWifiConnected()).append("\n");
		builder.append("是否 有Mobile已连接:").append(ConnectivityService.getInstance().isMobileConnected()).append("\n");
		
		builder.append("网络类型:").append(ConnectivityService.getInstance().getCurrentNetworkType()).append("\n");
		builder.append("精确的网络类型:").append(ConnectivityService.getInstance().getNetworkType()).append("\n");
		builder.append("模糊的网络类型:").append(ConnectivityService.getInstance().getFuzzyNetworkType()).append("\n");
		// builder.append("").append("").append("\n");
		// builder.append("").append("").append(""\n);
		
		ConnectivityService.getInstance().turnToWifiSettings();
		ConnectivityService.getInstance().turnToWirelessSettings();
		
		this.registerReceiver(mBroadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
	}
	
	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			Bundle bundle = intent.getExtras();
			NetworkInfo aNetworkInfo = (NetworkInfo) bundle
					.get(ConnectivityManager.EXTRA_NETWORK_INFO);

			if (aNetworkInfo.isAvailable()) {
				builder.append("available").append(" ");
			} else {
				builder.append("unavailable").append(" ");
			}
			
			if (aNetworkInfo.isConnected()) {
				builder.append("connected").append("\n");
			} else {
				builder.append("unconnected").append("\n");
			}
			textView.setText(builder.toString());
		}
	};
	
}
