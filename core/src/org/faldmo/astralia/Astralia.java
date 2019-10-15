package org.faldmo.astralia;

import swisseph.*;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.faldmo.astralia.screens.SplashScreen;
import org.faldmo.astralia.utils.Assets;

public class Astralia extends Game {
	public static SweDate sd;
	public static final String LOG = Astralia.class.getSimpleName();
	public static final boolean DEV_MODE = false;
	public static double myLatitude;
	public static double myLongitude;
	SpriteBatch batch;
	Texture img;

	public Astralia(double lat, double lon) {
		myLatitude = lat;
		myLongitude = lon;
	}


	
	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log( Astralia.LOG, "Creating game on " + Gdx.app.getType() );
		Assets.load();
		resetCalendar();
	}

	@Override
	public void render () {
		super.render();
	}

	public boolean setDate(SweDate newsd) {
		sd = newsd;
		return true;
	}
	
	@Override
	public void dispose () {
		super.dispose();
		Assets.dispose();
	}

	public void resetCalendar(){
		sd = new SweDate();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		Gdx.app.log(Astralia.LOG, "Resizing to:"+ width);
		if (getScreen() == null) {
			setScreen( new SplashScreen(this));
		}
	}

	@Override
	public void setScreen( Screen screen) {
		super.setScreen(screen);
		Gdx.app.log(Astralia.LOG, "Setting screen:" + screen.getClass());

	}

}
