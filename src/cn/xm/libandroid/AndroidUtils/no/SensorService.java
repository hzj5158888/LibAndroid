package cn.xm.libandroid.AndroidUtils.no;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import cn.xm.libandroid.AndroidUtils.Service;

public class SensorService extends Service {
	private static SensorService instance; 
	private SensorManager sensorManager;
	SensorEventListener sensorEventListener;
	Sensor sensor;
	
	private SensorService(Context context) {
		sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}
	
	public static SensorService getInstance() {
		if (instance == null) {
			instance = new SensorService(context);
		}
		return instance;
	}
	// <<===============================>>
	/**注册重力感应监听事件*/
	public void registerSensorListener(SensorEventListener sensorEventListener){
		this.sensorEventListener=sensorEventListener;
		sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_GAME);
	}

	public void registerSensorListener() {
		if (sensorEventListener!=null) {
			sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_GAME);	
		}else {
			Log.e(this.getClass().getCanonicalName(), "监听事件为空，注册失败！！！");
		}
	}

	public void unregisterListener() {
		if (sensorEventListener!=null) {
			sensorManager.unregisterListener(sensorEventListener);	
		}else {
			Log.e(this.getClass().getCanonicalName(), "监听事件为空，注销失败！！！");
		}	
	}
}
