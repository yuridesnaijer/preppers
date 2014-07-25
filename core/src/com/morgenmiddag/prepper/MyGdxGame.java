package com.morgenmiddag.prepper;

import com.badlogic.gdx.Game;
import com.morgenmiddag.prepper.screens.GameScreen;

public class MyGdxGame extends Game {
	public static final String 	TITLE = "Preppers",
								VERSION = "0.0.0.1";

	@Override
	public void create () {
		setScreen(new GameScreen());
	}
	
	@Override
	public void render () {
		super.render();
	}
	
	public void resize(int width, int height){
		super.resize(width, height);
	}
	
	public void pause(){
		super.pause();
	}
	
	public void resume(){
		super.resume();
	}
	
	public void dispose(){
		super.dispose();
	}
}
