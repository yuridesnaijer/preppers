package com.morgenmiddag.prepper.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class TestUI extends Actor {

	private Sprite sprite;
	
	public TestUI(){
		sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
		sprite.setRegionHeight(50);
		sprite.setRegionWidth(50);
		
		setBounds(0, 0, sprite.getRegionHeight(), Gdx.graphics.getWidth());
		setTouchable(Touchable.enabled);
		
		System.out.println("create Menu");
		this.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttons){
                System.out.println("Touched button");
                return true;
            }
        });
	}
	
	public void draw(Batch batch, float alpha){
        batch.draw(sprite, getX(), getY());
    }
}
