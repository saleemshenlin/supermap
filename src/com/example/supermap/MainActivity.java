package com.example.supermap;

import com.supermap.data.Environment;
import com.supermap.data.Workspace;
import com.supermap.data.WorkspaceConnectionInfo;
import com.supermap.data.WorkspaceType;
import com.supermap.mapping.MapControl;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private LocationManager gpsLocationManager;
	private Location lastLocation = null;

	private static final int MINTIME = 2000;
	private static final int MININSTANCE = 2;
	private static final double PI = 3.1459266;
	private static final double HALF_PI = 1.57079633;

	private static final int SCREEN_MAERGIN = 24;

	private int screenWidth;
	private int screenHeight;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ����һЩϵͳ��Ҫ�õ���·��
		Environment.setConfigFileDirectory(EnvironmentInit.CONFIG_FILE);
		Environment.setLicensePath(EnvironmentInit.LICENSE_PATH);
		Environment.setTemporaryPath(EnvironmentInit.TEMP_PATH);
		Environment.setWebCacheDirectory(EnvironmentInit.WEB_CACHE);

		// ������ܱ����� Environment ��ʼ��֮����ܵ���
		Environment.initialization(this);

		// �򿪹����ռ�
		Workspace workspace = new Workspace();
		WorkspaceConnectionInfo info = new WorkspaceConnectionInfo();
		info.setServer(EnvironmentInit.SAMPLE_DATA
				+ "/GeometryInfo/World.smwu");
		info.setType(WorkspaceType.SMWU);
		workspace.open(info);

		// ����ͼ��ʾ�ؼ��� �����ռ����
		MapControl mapControl = new MapControl(this, workspace);

		// �򿪹����ռ��е�ͼ�ĵ�������ͼ
		String mapName = workspace.getMaps().get(3);
		mapControl.getMap().open(mapName);
		mapControl.getMap().refresh();
		setContentView(mapControl);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
