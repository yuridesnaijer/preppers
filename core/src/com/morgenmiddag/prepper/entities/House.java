package com.morgenmiddag.prepper.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.morgenmiddag.prepper.MyGdxGame;
import com.morgenmiddag.prepper.ui.HousePopup;

public class House extends Actor{

	private Sprite sprite;
	private Boolean menuOpen = false;
	private HousePopup housePopup;
	
	private int hitPoints;
	private int level = 1;
	
	private House house;

    public Vector2 draggOffset = new Vector2();

	public House(int x, int y, int hp){
		
		house = this;
		
		System.out.println("create House");
		
		setHitPoints(hp);
		
		sprite = new Sprite(new Texture(Gdx.files.internal("house.png")));
		sprite.setSize(50, 50);
		sprite.setRegionHeight(50);
		sprite.setRegionWidth(50);

		setBounds(x, y, sprite.getRegionWidth(), sprite.getRegionHeight());
		setTouchable(Touchable.enabled);
		
		this.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttons){
                Gdx.app.log(MyGdxGame.TITLE, Float.toString((Gdx.input.getX() - getX())));

                //set draggoffset when first clicked on house, this will be used to prevent the house from jumping to its sprite's left corner
                draggOffset.x = Gdx.input.getX() - getX();
                draggOffset.y = Gdx.input.getY() - getY();

            	if(!menuOpen){
            		menuOpen = true;
            		housePopup = new HousePopup(house);
            		getStage().addActor(housePopup);
            		getStage().addActor(housePopup.getTable());
            		System.out.println("open menu");
            	} else {
            		housePopup.remove();
            		housePopup.getTable().remove();
            		menuOpen = false;
            		System.out.println("close menu");
            	}
                
                return true;
            }
            
            public void touchDragged (InputEvent event, float x, float y, int pointer) {
	            // example code below for origin and position

//                (getX()+x)
//                - (Gdx.input.getX() - getX()

	            house.setPosition((getX()+x) - draggOffset.x, getY()+y);
//	            System.out.println("touchdragged " + x + ", " + y);

	        }
        });
	}
	
	@Override
    public void draw(Batch batch, float alpha){
		batch.setColor(1,1,1,1);
        batch.draw(sprite, getX(), getY());
    }

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
