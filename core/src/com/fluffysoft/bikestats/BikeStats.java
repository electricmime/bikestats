package com.fluffysoft.bikestats;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class BikeStats extends Game {
	public static final int screenWidth = 800;
	public static final int screenHeight = 480;
	public SpriteBatch batch;
    public OrthographicCamera camera;
	public FitViewport viewport;
    public AssetManager manager;


	public BikeStats() {
		camera = new OrthographicCamera();
		camera.position.set(screenWidth/2, screenHeight/2, 0);
		viewport = new FitViewport(screenWidth, screenHeight, camera);
        manager = new AssetManager();
	}
	@Override
	public void create () {
		batch = new SpriteBatch();
        manager.load("background.png", Texture.class);
		manager.finishLoading();
		setScreen(new BikeScene(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
