package com.example.supermap;

import java.io.File;

import android.annotation.SuppressLint;
import android.os.Environment;


@SuppressLint("SdCardPath")
public class EnvironmentInit {

	// SampleData 
	public static final String SAMPLE_DATA =EnvironmentInit.getSDPath() + "/SampleData";

	// ConfigFile Directory
	public static final String CONFIG_FILE =EnvironmentInit.getSDPath() + "/SuperMap/config/";
	// License Path
	public static final String LICENSE_PATH =EnvironmentInit.getSDPath() + "/SuperMap/license/";
	// Temporary Path
	public static final String TEMP_PATH =EnvironmentInit.getSDPath() + "/SuperMap/temp/";
	// Web Cache Directory
	public static final String WEB_CACHE =EnvironmentInit.getSDPath() + "/SuperMap/WebCache/";

	public static String getSDPath() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory();// 获取跟目录
		}
		return sdDir.toString();

	}

}
