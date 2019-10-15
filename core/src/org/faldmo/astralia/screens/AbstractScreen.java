package org.faldmo.astralia.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;

import org.faldmo.astralia.Astralia;

public class AbstractScreen implements Screen {
    // the fixed viewport dimensions (ratio: 1.6)
    public static final int ZODIAC_VIEWPORT_WIDTH = 800, ZODIAC_VIEWPORT_HEIGHT = 480;
    public static final int MENU_VIEWPORT_WIDTH = 800, MENU_VIEWPORT_HEIGHT = 480;

    protected final Astralia astralia;
    protected final Stage stage;

    private BitmapFont font;
    private SpriteBatch batch;
    private Skin skin;
    private TextureAtlas atlas;
    private Table table;

    public AbstractScreen(Astralia as) {
        this.astralia = as;
        int width = ( isZodiacScreen() ? ZODIAC_VIEWPORT_WIDTH : MENU_VIEWPORT_WIDTH );
        int height = ( isZodiacScreen() ? ZODIAC_VIEWPORT_HEIGHT : MENU_VIEWPORT_HEIGHT );
        this.stage = new Stage( new FitViewport(width, height));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        // (1) process the game logic

        // update the actors
        stage.act( delta );
        // stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        // (2) draw the result

        // clear the screen with the given RGB color (black)
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        stage.getCamera().update();
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        // draw the actors
        stage.draw();

        // draw the table debug lines
        //Table.drawDebug( stage );

    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(Astralia.LOG, "Resizing screen");
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    protected boolean isZodiacScreen() {
        return false;
    }

    public BitmapFont getFont() {
        if (font == null) {
            font = new BitmapFont();
        }
        return font;
    }

        public SpriteBatch getBatch()
    {
        if( batch == null ) {
            batch = new SpriteBatch();
        }
        return batch;
    }

    public TextureAtlas getAtlas()
    {
        if( atlas == null ) {
            atlas = new TextureAtlas( Gdx.files.internal( "data/symbols.atlas" ) );
        }
        return atlas;
    }


    protected Skin getSkin()
    {
        if( skin == null ) {
            FileHandle skinFile = Gdx.files.internal( "skin/uiskin.json" );
            skin = new Skin( skinFile );
        }
        if (skin == null) {
            Gdx.app.log(Astralia.LOG, "Jeg tror skinn er null!");
        }

        return skin;
    }

    protected Table getTable()
    {
        if( table == null ) {
            table = new Table( getSkin() );
            table.setFillParent( true );
            if( Astralia.DEV_MODE ) {
                table.debug();
            }
            stage.addActor( table );
        }
        return table;
    }
}
