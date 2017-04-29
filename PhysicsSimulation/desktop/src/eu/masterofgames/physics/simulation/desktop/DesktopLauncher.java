package eu.masterofgames.physics.simulation.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import eu.masterofgames.physics.simulation.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);

		config.title = "Phisics Simulation";
        config.resizable = false;
        config.height = 600;
        config.width = 800;
	}
}
