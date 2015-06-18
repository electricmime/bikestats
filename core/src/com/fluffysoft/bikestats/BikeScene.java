package com.fluffysoft.bikestats;

import com.badlogic.gdx.Gdx;
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
    Label calorie;
    Label distance;
    Label incline;
    Label pulse;
    Label rpm;
    Label speed;
    Label time;
    Label watt;

    public BikeScene(BikeStats bikestats){
        super(bikestats);

        stage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        screenBg = new Image(game.manager.get("background.png", Texture.class));

        table = new Table();
        calorie = new Label("calorie: ",skin);
        table.add(calorie).padBottom(10);
        table.row();
        distance = new Label("distance: ",skin);
        table.add(distance).padBottom(10);
        table.row();
        incline = new Label("incline: ",skin);
        table.add(incline).padBottom(10);
        table.row();
        pulse = new Label("pulse: ",skin);
        table.add(pulse).padBottom(10);
        table.row();
        rpm = new Label("rpm: ",skin);
        table.add(rpm).padBottom(10);
        table.row();
        speed = new Label("speed: ",skin);
        table.add(speed).padBottom(10);
        table.row();
        time = new Label("time: ",skin);
        table.add(time).padBottom(10);
        table.row();
        watt = new Label("watt: ",skin);
        table.add(watt).padBottom(10);
        table.row();
        table.setPosition(400,240);


        stage.addActor(screenBg);
        stage.addActor(table);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        super.render(delta);

    }
}
