package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Screens.Screen1;

public class Bullet {

    public static final int SPEED = 750;
    private static Texture texture;
    World world;

    float x, y;

    public boolean remove = false;

    public Bullet (float x, float y){
        this.x = x;
        this.y = y;
        world = new World(new Vector2(0, -9.81f), true);
        if(texture == null)
        {
            texture = new Texture("Tennis-Ball.png");
        }
    }

    public void update(float deltaTime){
        x+= SPEED * deltaTime;
        y = world.
        if(y > Gdx.graphics.getHeight() || x > Gdx.graphics.getWidth())
        {
            remove = true;
        }
    }

    public void render(SpriteBatch batch)
    {
        batch.draw(texture, x, y, 50, 50);
    }
}
