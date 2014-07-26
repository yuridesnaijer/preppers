package com.morgenmiddag.prepper.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.morgenmiddag.prepper.Player;

public class Hud extends Stage{

	private TextureAtlas atlas;
	private Skin skin;
	private Label score;
	
	public Hud(Player player){
		atlas = new TextureAtlas("ui/atlas.pack");
		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);
		
		score = new Label("$ " + player.getMoney(), skin);
		
		this.addActor(score);
	}
	
}
