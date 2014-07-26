package com.morgenmiddag.prepper.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.morgenmiddag.prepper.Player;
import com.morgenmiddag.prepper.entities.House;
import com.morgenmiddag.prepper.ui.Hud;

public class GameScreen implements Screen {

	private Stage stage, hud;
	private House house;
	private Player player;
	
	private TextureAtlas atlas;
	private Label score;
	private Skin skin;
	
	public GameScreen(Player player){
		this.player = player;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Table.drawDebug(stage);
		
		stage.act();
		stage.draw();
		
		hud.act();
		hud.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void show() {		
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);	
		
		house = new House();
		stage.addActor(house);		

		hud = new Hud(player);	
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
