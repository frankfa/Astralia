package org.faldmo.astralia.screens;

import org.faldmo.astralia.Astralia;
import org.faldmo.astralia.utils.Assets;


import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SplashScreen extends AbstractScreen {
    private Image splashImage;
    private Image logoImage;
    private Image sophImage;

    public SplashScreen(Astralia as) {
        super(as);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void show() {
        super.show();

        // create the splash image actor;
        splashImage = new Image(Assets.splashBackground);
        logoImage = new Image(Assets.logo);
        logoImage.setOrigin(logoImage.getWidth() / 2, logoImage.getHeight() / 2);
        sophImage = new Image(Assets.sophus);
        sophImage.setOrigin(sophImage.getWidth() / 2, logoImage.getHeight() / 2);

        float sentx = MENU_VIEWPORT_WIDTH / 2 - logoImage.getWidth() / 2;

        logoImage.setPosition(200f, 100f);
        //splashImage = new Image(splashDrawable, Scaling.stretch);
        splashImage.setFillParent(true);
        //logoImage.addAction(sequence(moveTo(200,100,2,Interpolation.bounceOut), delay(0.5f), scaleTo(0.5f,0.5f, 1)));

        logoImage.addAction(Actions.parallel
                (Actions.scaleTo(0.3f, 0.3f),
                        moveTo(sentx, MENU_VIEWPORT_HEIGHT / 2, 1.5f),
                        Actions.scaleTo(1f, 1f, 1.5f, Interpolation.bounceOut)));

        sophImage.setPosition(200, 200);
        sophImage.addAction(Actions.sequence(
                moveTo(200, 10),
                scaleTo(0.2f, 0.2f),
                Actions.rotateBy(-60),
                fadeOut(0),
                delay(0.3f),
                parallel(moveBy(50, 100, 1.5f, Interpolation.swingOut),
                        scaleTo(1.0f, 1.0f, 0.75f, Interpolation.linear),
                        Actions.rotateBy(60, 1f),
                        alpha(1.0f, 0.5f))));

//				(scaleTo(0.2f, 0.2f),
//						moveTo(350,100,2),
//						scaleTo(1f, 1f, 2))
//						);

        // this is needed for the fade-in effect to work correctly; we're just
        // making the image completely transparent

        // configure the fade-in/out effect on the splash image
        splashImage.addAction(Actions.sequence
                (Actions.alpha(0), Actions.fadeIn(0.7f),
                        Actions.delay(3), Actions.run(new Runnable() {
                            @Override
                            public void run() {
                                astralia.setScreen(new MenuScreen(astralia));
                            }
                        })));

        // and finally we add the actor to the stage

        stage.addActor(splashImage);
        stage.addActor(logoImage);
        stage.addActor(sophImage);
    }
}