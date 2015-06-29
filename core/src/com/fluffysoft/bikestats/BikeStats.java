package com.fluffysoft.bikestats;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
	public double distance = 0.0D;
	public double speed = 0.0D;
	public short time = 0;
	public short calorie = 0;
	public short watt = 0;
	public byte incline = 0;
	public int pulse = 0;
	public int rpm = 0;
	public BikeScene scene;
    public String brand = new String("Unknown");
    public String manufacturer = new String("Unknown");
	public BikeRequest request;

	public BikeStats(BikeRequest r) {
		request = r;
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
		scene = new BikeScene(this);
		setScreen(scene);
	}

	@Override
	public void render () {
		speed = request.getSpeed();
		scene.setSpeed();
		pulse = request.getPulse();
		scene.setPulse();
		incline = request.getIncline();
		scene.setIncline();

		if(!request.isConnected()) {
			brand = "DISCONNECTED";
			scene.setBrand();
		}
		if(!request.isRunning()) {
			manufacturer = "NOTRUNNING";
			scene.setManufacturer();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
			request.startCustom(3600, 2.0, 200, 43, true, 68, 337, true);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
			rpm  += 10;
			scene.setRpm();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.T)){
			time += 10;
			scene.setTime();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
			watt += 10;
			scene.setWatt();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.I)){
			incline += 10;
			scene.setIncline();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.P)){
			pulse += 10;
			scene.setPulse();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
			calorie += 10;
			scene.setCalorie();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
			distance += 10;
			scene.setDistance();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
			speed += 10;
			scene.setSpeed();
		}
        if(Gdx.input.isKeyJustPressed(Input.Keys.X)){
            Gdx.app.exit();
        }

		super.render();

	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
