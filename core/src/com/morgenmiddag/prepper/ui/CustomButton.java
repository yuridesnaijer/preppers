package com.morgenmiddag.prepper.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class CustomButton extends TextButton{

	public CustomButton(String text, Skin skin) {
		super(text, skin);
		
		this.pad(10);		
		this.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;  // must return true for touchUp event to occur
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	//((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen());
            }
            
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
            	// TODO Auto-generated method stub            	
            	super.touchDragged(event, x, y, pointer);
            }
		});
		
	}

}
