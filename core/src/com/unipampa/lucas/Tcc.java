package com.unipampa.lucas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.unipampa.lucas.model.Bucket;

public class Tcc extends ApplicationAdapter {
    private SpriteBatch batch;
    private Bucket bucket;
    private OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bucket = new Bucket();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        bucket.draw(batch);
        batch.end();
        bucket.move(camera);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
