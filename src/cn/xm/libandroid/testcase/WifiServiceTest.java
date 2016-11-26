package cn.xm.libandroid.testcase;

import android.os.Bundle;
import cn.xm.libandroid.AndroidUtils.ActivityService;
import cn.xm.libandroid.AndroidUtils.WifiService;


/***
 * 测试  WifiService类
 * @author yesunsong
 *
 */
public class WifiServiceTest extends SingleTouchTest {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTestSingleTouch(false);
	}
	
	@Override
	protected void handleTouchUpEvent() {
		StringBuilder builder=new StringBuilder();
		builder.append("根据当前WiFi状态,开关WiFi").append("\n");
		if (WifiService.getInstance().isWifiEnabled()) {
			WifiService.getInstance().closeWifi();
		}else {
			WifiService.getInstance().openWifi();
		}
		builder.append("当前WIFI状态：").append(WifiService.getInstance().isWifiEnabled()).append("\n");
		builder.append("WIFI信息：").append(WifiService.getInstance().getWifiInfo()).append("\n");
		builder.append("SSID：").append(WifiService.getInstance().getSSID()).append("\n");
		builder.append("BSSID：").append(WifiService.getInstance().getBSSID()).append("\n");
		builder.append("MAC地址：").append(WifiService.getInstance().getMacAddress()).append("\n");
		builder.append("Supplicant state：").append(WifiService.getInstance().getMacAddress()).append("\n");
		builder.append("RSSI：").append(WifiService.getInstance().getRssi()).append("\n");
		builder.append("Link speed：").append(WifiService.getInstance().getLinkSpeed()).append("\n");
		builder.append("Net ID：").append(WifiService.getInstance().getNetworkId()).append("\n");
		builder.append("Metered hint：").append(WifiService.getInstance().getMeteredHint()).append("\n");
		WifiService.getInstance().startScan();
//		builder.append("网络列表：").append("\n").append(WifiService.getInstance().lookUpScan()).append("\n");
		builder.append("OpenGL ES Ver：").append(ActivityService.getInstance().getOpenGLESVer());
		
		textView.setText(builder.toString());
	}
}
