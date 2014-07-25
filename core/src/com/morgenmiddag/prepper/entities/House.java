package com.morgenmiddag.prepper.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;
import com.morgenmiddag.prepper.ui.TestUI;

public class House extends Actor{

	private Sprite sprite;
	private Boolean menuOpen = false;
	
	private TestUI houseMenu;
	
	public House(){
		
		System.out.println("create House");
		
		sprite = new Sprite(new Texture(Gdx.files.internal("house.png")));
		sprite.setSize(50, 50);
		sprite.setRegionHeight(50);
		sprite.setRegionWidth(50);
		
		setBounds(Gdx.graphics.getHeight() /2, Gdx.graphics.getWidth()/2, sprite.getRegionHeight(), sprite.getRegionWidth());
		setTouchable(Touchable.enabled);
		
		this.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttons){
            	if(menuOpen == false){
            		menuOpen = true;
            		houseMenu = new TestUI();
            		getStage().addActor(houseMenu);
            	} else {
            		houseMenu.remove();
            		menuOpen = false;
            	}
                
                return true;
            }
        });
	}
	
	@Override
    public void draw(Batch batch, float alpha){
        batch.draw(sprite, getX(), getY());
    }
}
