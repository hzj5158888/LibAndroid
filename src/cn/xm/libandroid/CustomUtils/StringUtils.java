package cn.xm.libandroid.CustomUtils;

import java.text.DecimalFormat;

public class StringUtils {

	
	private static DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * 格式化大小
	 * 
	 * @param size
	 * @return
	 */
	public static String formatSize(long size) {
		String unit = "B";
		float len = size;
		if (len > 900) {
			len /= 1024f;
			unit = "KB";
		}
		if (len > 900) {
			len /= 1024f;
			unit = "MB";
		}
		if (len > 900) {
			len /= 1024f;
			unit = "GB";
		}
		if (len > 900) {
			len /= 1024f;
			unit = "TB";
		}
		return df.format(len) + unit;
	}

	public static String formatSizeBySecond(long size) {
		String unit = "B";
		float len = size;
		if (len > 900) {
			len /= 1024f;
			unit = "KB";
		}
		if (len > 900) {
			len /= 1024f;
			unit = "MB";
		}
		if (len > 900) {
			len /= 1024f;
			unit = "GB";
		}
		if (len > 900) {
			len /= 1024f;
			unit = "TB";
		}
		return df.format(len) + unit + "/s";
	}

	public static String format(long size) {
		String unit = "B";
		float len = size;
		if (len > 1000) {
			len /= 1024f;
			unit = "KB";
			if (len > 1000) {
				len /= 1024f;
				unit = "MB";
				if (len > 1000) {
					len /= 1024f;
					unit = "GB";
				}
			}
		}
		return df.format(len) + "\n" + unit + "/s";
	}
	
}
