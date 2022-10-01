package com.unipampa.lucas.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bucket {

    private final Texture bucketImage;

    private final Rectangle collider;

    public Bucket() {
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
        collider = new Rectangle();
        collider.x = 800f / 2f - 64f / 2f;
        collider.y = 20;
        collider.width = 64;
        collider.height = 64;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(bucketImage, collider.x, collider.y);
    }

    public void move(OrthographicCamera camera) {
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            collider.x = touchPos.x - 64f / 2f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            collider.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            collider.x += 200 * Gdx.graphics.getDeltaTime();
        }
    }

}
