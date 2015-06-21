package com.fluffysoft.bikestats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class BikeScene extends BaseScene {
    Stage stage;
    Skin skin;
    Image screenBg;
    Table table;
    Label calorieLabel;
    Label distanceLabel;
    Label inclineLabel;
    Label pulseLabel;
    Label rpmLabel;
    Label speedLabel;
    Label timeLabel;
    Label wattLabel;
    Label brandLabel;
    Label manLabel;



    public BikeScene(BikeStats bikestats){
        super(bikestats);

        stage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        screenBg = new Image(game.manager.get("background.png", Texture.class));

        table = new Table();
        calorieLabel = new Label("calorie: ",skin);
        table.add(calorieLabel).padBottom(10);
        table.row();
        distanceLabel = new Label("distance: ",skin);
        table.add(distanceLabel).padBottom(10);
        table.row();
        inclineLabel = new Label("incline: ",skin);
        table.add(inclineLabel).padBottom(10);
        table.row();
        pulseLabel = new Label("pulse: ",skin);
        table.add(pulseLabel).padBottom(10);
        table.row();
        rpmLabel = new Label("rpm: ",skin);
        table.add(rpmLabel).padBottom(10);
        table.row();
        speedLabel = new Label("speed: ",skin);
        table.add(speedLabel).padBottom(10);
        table.row();
        timeLabel = new Label("time: ",skin);
        table.add(timeLabel).padBottom(10);
        table.row();
        wattLabel = new Label("watt: ",skin);
        table.add(wattLabel).padBottom(10);
        table.row();
        brandLabel = new Label("brand: ",skin);
        table.add(brandLabel).padBottom(10);
        table.row();
        manLabel = new Label("man: ",skin);
        table.add(manLabel).padBottom(10);
        table.row();
        table.setPosition(400,240);


        stage.addActor(screenBg);
        stage.addActor(table);
    }
    public void setManufacturer(){
        manLabel.setText("man: " + game.manufacturer);
    }
    public void setBrand(){
        brandLabel.setText("brand: " + game.brand);
    }
    public void setWatt(){
        wattLabel.setText("watt: " + game.watt);
    }
    public void setTime(){
        timeLabel.setText("time: " + game.time);
    }
    public void setCalorie(){
        calorieLabel.setText("calorie: " + game.calorie);
    }
    public void setDistance(){
        distanceLabel.setText("distance: " + game.distance);
    }
    public void setIncline(){
        inclineLabel.setText("incline: " + game.incline);
    }
    public void setPulse(){
        pulseLabel.setText("pulse: " + game.pulse);
    }
    public void setRpm(){
        rpmLabel.setText("rpm: " + game.rpm);
    }
    public void setSpeed(){
        System.out.println("BIKE: Setting speed to " + game.speed);
        speedLabel.setText("speed: " + game.speed);
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        super.render(delta);

    }
}
