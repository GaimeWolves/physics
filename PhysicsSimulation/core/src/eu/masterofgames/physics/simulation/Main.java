package eu.masterofgames.physics.simulation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

	private World world;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		world = new World();

		world.createRectangle(375, 540, 50, 50, new Color(0, 0, 1, 1), false);
		world.createRectangle(0, 0, 800, 50, new Color(0.5f, 0.5f, 0.5f, 1), true);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.update(Gdx.graphics.getDeltaTime());
		world.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
