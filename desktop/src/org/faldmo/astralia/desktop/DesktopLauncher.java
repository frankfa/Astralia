package org.faldmo.astralia.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.faldmo.astralia.Astralia;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Astralia";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new Astralia(10,10), config);
	}
}
