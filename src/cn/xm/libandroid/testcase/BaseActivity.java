package cn.xm.libandroid.testcase;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import cn.xm.libandroid.AndroidUtils.AndroidSetting;
import cn.xm.libandroid.implement.Application;

public class BaseActivity extends Activity {
	StringBuilder builder = new StringBuilder();
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Application.initService(this);
		AndroidSetting.getInstance().setFullScreen();
		AndroidSetting.getInstance().setScreenAlawaysBright();
		AndroidSetting.getInstance().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  
		//
		textView = new TextView(this);
		textView.requestFocus();
		textView.setFocusable(true);
		textView.setText(builder.toString());
		// 以下代码实现 多行文本滚动
		textView.setMaxLines(16);
		textView.setSingleLine(false);
		// setVerticalScrollBarEnabled(true)等价于 在xml中的android:scrollbars="none"
		textView.setVerticalScrollBarEnabled(true);
		textView.setMovementMethod(ScrollingMovementMethod.getInstance());
		setContentView(textView);
	}

	protected void log(String text) {
		Log.d(this.getClass().getSimpleName(), text);
		builder.append(text).append("\n");
		textView.setText(builder.toString());
	}

	protected void log2(String text) {
		Log.d(this.getClass().getSimpleName(), text);
		textView.setText(text);
	}
	
	public Button createButton(String text){
		Button button=new Button(this);
		button.setText(text);
		return button;
	}
}
