package com.fluffysoft.bikestats.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fluffysoft.bikestats.BikeStats;

public class DesktopLauncher {
	static BikeStats bikestats;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 480;
		bikestats = new BikeStats();

		new LwjglApplication(bikestats, config);
	}
}
