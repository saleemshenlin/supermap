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
				Environment.MEDIA_MOUNTED); // �ж�sd���Ƿ����
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory();// ��ȡ��Ŀ¼
		}
		return sdDir.toString();

	}

}
