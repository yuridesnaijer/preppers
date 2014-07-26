package com.morgenmiddag.prepper;

import com.badlogic.gdx.Game;
import com.morgenmiddag.prepper.screens.GameScreen;

public class MyGdxGame extends Game {
	public static final String 	TITLE = "Preppers",
								VERSION = "0.0.0.1";
	private Player player;

	@Override
	public void create () {
		
		player = new Player();
		setScreen(new GameScreen(player));
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
