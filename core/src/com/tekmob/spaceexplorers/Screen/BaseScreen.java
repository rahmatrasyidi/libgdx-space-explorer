package com.tekmob.spaceexplorers.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tekmob.spaceexplorers.SpaceExplorer;

/**
 * Created by Rahmat Rasyidi Hakim on 11/20/2014.
 */
public abstract class BaseScreen implements Screen {

    protected SpaceExplorer spaceExplorer;
    protected Stage stage;
    
    public BaseScreen(SpaceExplorer s) {
    	this(s, new FitViewport(SpaceExplorer.WIDTH, SpaceExplorer.HEIGHT));
    }

    public BaseScreen(SpaceExplorer s, Viewport vp){
        spaceExplorer = s;
        stage = new Stage(vp);
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        onBackScreen();
        inputHandler();
    }

    @Override
    public void resize(int width, int height) {
    	stage.getViewport().update(width, height);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
    	Gdx.input.setInputProcessor(null);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
    	stage.dispose();
    }
    
    public boolean onBack() {
    	return true;
    }
    
    public void inputHandler() {
    	
    }

    public void onBackScreen() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK) || Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
            if(onBack()) spaceExplorer.getScreenstack().pop();
        }
    }
}
