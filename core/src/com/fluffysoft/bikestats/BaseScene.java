package com.fluffysoft.bikestats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;

/**
 * Created by rzerby on 6/6/2015.
 */
public class BaseScene extends ScreenAdapter {
    protected BikeStats game;
    private boolean keyHandled;

    public BaseScene(BikeStats planeGame) {
        game = planeGame;
        keyHandled = false;
        Gdx.input.setCatchBackKey(true);
        Gdx.input.setCatchMenuKey(true);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            if (keyHandled) {
                return;
            }
            handleBackPress();
            keyHandled = true;
        } else {
            keyHandled = false;
        }
    }

    protected void handleBackPress() {
        System.out.println("back");
    }
}