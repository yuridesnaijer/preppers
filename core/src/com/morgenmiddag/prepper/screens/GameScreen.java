package com.morgenmiddag.prepper.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.morgenmiddag.prepper.MyGdxGame;
import com.morgenmiddag.prepper.Player;
import com.morgenmiddag.prepper.entities.Enemy;
import com.morgenmiddag.prepper.entities.House;
import com.morgenmiddag.prepper.ui.Hud;

import java.util.Random;

public class GameScreen implements Screen {

	private Stage stage, hud;
	private House house, house2;
	private Player player;

    private Enemy enemy;

    private float timer = 0;
    private Array<Vector2> enemyPath1;
    private Array<Vector2> enemyPath2;
    private Array<Vector2> enemyPath3;
    private Array<Vector2> randomPath;

    private Random random;
    private Vector2 enemyStartPosition;

    public GameScreen(Player player){
		this.player = player;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        timer+= Gdx.graphics.getDeltaTime();

		Table.drawDebug(stage);
		
		stage.act();
		stage.draw();
		
		hud.act();
		hud.draw();

        //create enemy after periods of ... seconds
        if(timer >= 4){
            enemyStartPosition = new Vector2(-50, 100);

            getRandomPath();
            stage.addActor(new Enemy(enemyStartPosition, randomPath));

            timer = 0;
        }

	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void show() {
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);

		house = new House(50, 50, 400);
		house2 = new House(250, 250, 500);

        // create 3 different paths
        // set new enemy with new path and add it to stage
        random = new Random();

        enemyStartPosition = new Vector2(-50, 100);

        createEnemyPaths();
        getRandomPath();

        enemy = new Enemy(enemyStartPosition, randomPath);

		stage.addActor(house);	
		stage.addActor(house2);
        stage.addActor(enemy);

		hud = new Hud(player);	
		
	}

    private void createEnemyPaths() {
        enemyPath1 = new Array<Vector2>();
        enemyPath1.add(new Vector2(100, 300));
        enemyPath1.add(new Vector2(200, 150));
        enemyPath1.add(new Vector2(300, 100));
        enemyPath1.add(new Vector2(400, 150));

        enemyPath2 = new Array<Vector2>();
        enemyPath2.add(new Vector2(30, 20));
        enemyPath2.add(new Vector2(170, 80));
        enemyPath2.add(new Vector2(220, 400));
        enemyPath2.add(new Vector2(600, 70));


        enemyPath3 = new Array<Vector2>();
        enemyPath3.add(new Vector2(120, 400));
        enemyPath3.add(new Vector2(210, 330));
        enemyPath3.add(new Vector2(250, 223));
        enemyPath3.add(new Vector2(370, 280));
    }

    private void getRandomPath(){
        switch (random.nextInt(3)){
            case 0:
                randomPath = enemyPath1;
                break;
            case 1:
                randomPath = enemyPath2;
                break;
            case 2:
                randomPath = enemyPath3;
                break;
        }
    }

    @Override
	public void hide() {
		dispose();

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
        stage.dispose();
        hud.dispose();
	}
}
