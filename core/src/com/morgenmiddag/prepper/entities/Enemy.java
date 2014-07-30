package com.morgenmiddag.prepper.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.morgenmiddag.prepper.MyGdxGame;

import java.awt.*;

public class Enemy extends Actor {

    private Texture _texture;
    private Sprite _enemySprite;
    private Array<Vector2> _path;

    private int _waypoint = 0;
    private float speed = 100, tolerance = 3;

    private Vector2 _currentPos = new Vector2();
    private Vector2 _velocity = new Vector2();
    private boolean lastPointIsReached;


    public Enemy(Vector2 startPosition, Array<Vector2> path){

        _currentPos.x = startPosition.x;
        _currentPos.y = startPosition.y;

        _texture = new Texture("prepper_enemy.png");
        _enemySprite = new Sprite(_texture);

        _enemySprite.setSize(80,80);
        _enemySprite.setOrigin(_enemySprite.getWidth() / 2, _enemySprite.getHeight() / 2);
        _enemySprite.setPosition(startPosition.x, startPosition.y);


        _path = path;
    }


    @Override
    public void act(float delta) {
//        Gdx.app.log(MyGdxGame.TITLE, "ENEMY_ACT");

        float angle = (float) Math.atan2(_path.get(_waypoint).y - _enemySprite.getY(), _path.get(_waypoint).x - _enemySprite.getX());
        _velocity.set((float) Math.cos(angle) * speed, (float) Math.sin(angle) * speed);

        _enemySprite.setPosition(_enemySprite.getX() + _velocity.x * delta, _enemySprite.getY() + _velocity.y * delta);

        if(waypointIsReached()) {
            setPosition(_path.get(_waypoint).x, _path.get(_waypoint).y);
            if(_waypoint >= _path.size-1) {
                //last way point of path has been reached

//                _waypoint = 0;
                    lastPointIsReached = true;
            }else {
                _waypoint++;
            }
        }

        if(lastPointIsReached){

            //if last waypoint is reached by the enemy and it is off screen, remove it
            //else add a last waypoint to move it off screen, once it is off screen it will be automatticaly removed

            if(_enemySprite.getX() >= Gdx.graphics.getWidth()){
                remove();
            }else{
                //this'll add a last waypoint to the enemy's path, this will guide him to the bounds of the screen and to the center in height
                _path.add(new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2 - _enemySprite.getHeight()/2));
                _waypoint++;
            }
        }
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        _enemySprite.draw(batch);
    }

    private boolean waypointIsReached(){
        return _path.get(_waypoint).x - _enemySprite.getX() <= speed / tolerance * Gdx.graphics.getDeltaTime() && _path.get(_waypoint).y - _enemySprite.getY() <= speed / tolerance * Gdx.graphics.getDeltaTime();
    }

}
