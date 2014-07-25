package com.morgenmiddag.prepper.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.morgenmiddag.prepper.screens.GameScreen;

public class TestUI extends Actor {

	public Table table;
	private List list;
	private TextureAtlas atlas;
	private Skin skin;
	private ScrollPane scrollPane;
	private TextButton play, back;
	
	private Sprite sprite;
	
	public TestUI(){
		atlas = new TextureAtlas("ui/atlas.pack");
		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//set debug lines
		table.debug();
		
		list = new List<String>(skin);
		list.setItems(new String[] {"test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test"});
		
		scrollPane = new ScrollPane(list, skin);
		
		table.add().width(table.getWidth() / 3);
		table.add().width(table.getWidth() / 3).row();
		table.add(scrollPane).expandY().left();
	}
	
	@Override
	public void draw(Batch batch, float alpha){
        //batch.draw(sprite, getX(), getY());
    }
}
