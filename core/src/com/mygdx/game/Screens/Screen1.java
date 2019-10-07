package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Bullet;
import com.mygdx.game.CollisionRect;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

public class Screen1 implements Screen {

    public static final int SPEED = 120;

    Texture img;
    Texture trashcan;
    Texture fonties;
    float X;
    float Y;
    CollisionRect trashrect;

    MyGdxGame game;

    ArrayList<Bullet> bullets;

    public Screen1(MyGdxGame game)
    {
        this.game = game;
        bullets = new ArrayList<>();
        trashrect = new CollisionRect(1150, 10, 220, 350);
    }

    @Override
    public void show() {
        img = new Texture("badlogic.jpg");
        trashcan = new Texture("Trashcan.png");
        fonties = new Texture("Fonties icon.png");
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullets.add(new Bullet(0, 2));
        }

        ArrayList<Bullet> bulletToRemove = new ArrayList<>();

        for (Bullet bullet: bullets) {
            bullet.update(delta);
            if(bullet.remove)
            {
                bulletToRemove.add(bullet);
            }
        }

        for (Bullet bullet: bullets) {
            if(bullet.getCollisionRect().collidesWith(trashrect))
            {
                bulletToRemove.add(bullet);
            }
        }

        bullets.removeAll(bulletToRemove);

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        game.batch.draw(trashcan, 1150, 10, 220, 400);
        game.batch.draw(fonties, 1500, 900, 300, 150);
        for (Bullet bullet: bullets) {
            bullet.render(game.batch);
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
