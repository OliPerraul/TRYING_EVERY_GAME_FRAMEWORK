package com.javaquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cirrus.ColorUtils;
import com.cirrus.GLUtils;

public class Game extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture img;

    public CameraController cameraController;
    public Level level;

    private static Game instance;
    public static Game instance() {
        return instance;
    }

    @Override
    public void create() {
    	instance = this;
        batch = new SpriteBatch();
        cameraController = new CameraController(new OrthographicCamera());
        level = new Level();
    }

    @Override
    public void render() {
        GLUtils.glClearColor(ColorUtils.CORNFLOWER_BLUE);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cameraController.update(Gdx.graphics.getDeltaTime());
        level.update(Gdx.graphics.getDeltaTime());
        level.render(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}