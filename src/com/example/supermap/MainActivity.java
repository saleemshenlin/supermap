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

		// 设置一些系统需要用到的路径
		Environment.setConfigFileDirectory(EnvironmentInit.CONFIG_FILE);
		Environment.setLicensePath(EnvironmentInit.LICENSE_PATH);
		Environment.setTemporaryPath(EnvironmentInit.TEMP_PATH);
		Environment.setWebCacheDirectory(EnvironmentInit.WEB_CACHE);

		// 组件功能必须在 Environment 初始化之后才能调用
		Environment.initialization(this);

		// 打开工作空间
		Workspace workspace = new Workspace();
		WorkspaceConnectionInfo info = new WorkspaceConnectionInfo();
		info.setServer(EnvironmentInit.SAMPLE_DATA
				+ "/GeometryInfo/World.smwu");
		info.setType(WorkspaceType.SMWU);
		workspace.open(info);

		// 将地图显示控件和 工作空间关联
		MapControl mapControl = new MapControl(this, workspace);

		// 打开工作空间中地图的第三幅地图
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
