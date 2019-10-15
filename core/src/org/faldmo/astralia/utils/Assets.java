package org.faldmo.astralia.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {


    public static TextureAtlas atlas;
    public static Texture menuBackground;
    public static Texture splashBackground;
    public static Texture starMap;
    public static Skin menuSkin;
    public static Skin optionSkin;

    public static TextureRegion logo;
    public static TextureRegion sophus;
    public static TextureRegion closeButton;
    public static TextureRegion blacklabel;

    public static TextureRegion newmoon;
    public static TextureRegion firstquarter;
    public static TextureRegion fullmoon;
    public static TextureRegion lastquarter;

    public static TextureRegion rising;
    public static TextureRegion setting;
    public static TextureRegion transit;
    public static TextureRegion scarab;


    public static TextureRegion sun;


    public static BitmapFont menuFont;
    public static BitmapFont bigFont;
    public static BitmapFont infoFont;


    public static void load() {
        // READ ALL BIG SHIT
        atlas = new TextureAtlas("data/symbols.atlas");

        // TEXTURES
        menuBackground = new Texture(
                Gdx.files.internal("data/menubackground.png"));

        splashBackground = new Texture(
                Gdx.files.internal("data/splashbackground.png"));

        starMap = new Texture(Gdx.files.internal("data/mapImage.png"));


        // SKINA
        menuSkin = new Skin(Gdx.files.internal("data/symbols.json"));
        optionSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));


        // GENERATE FONTS
//              String fontFile = "data/LiberationSans-Bold.ttf";
        String fontFile = "data/LatoReg.ttf";
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
                Gdx.files.internal(fontFile));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 22;
        menuFont = generator.generateFont(parameter);
        parameter.size = 42;
        bigFont = generator.generateFont(parameter);
        parameter.size = 36;
        infoFont = generator.generateFont(parameter);
        generator.dispose(); // don't forget to dispose to avoid memory leaks!

        // CACHE DIFFERENT REGIONS
        closeButton = atlas.findRegion("close");
        logo = atlas.findRegion("logo");
        sophus = atlas.findRegion("sopsoft");

        // Menu option buttons
        blacklabel = atlas.findRegion("blackLabel");

//              newmoon = atlas.findRegion("newMLabel");
//              firstquarter = atlas.findRegion("firstQMLabel");
//              lastquarter = atlas.findRegion("lastQMLabel");
//              fullmoon = atlas.findRegion("fullMLabel");

        //
        rising = atlas.findRegion("up");
        setting = atlas.findRegion("down");
        transit = atlas.findRegion("transit");
        scarab = atlas.findRegion("scarab");
    }

        public static void dispose () {
            splashBackground.dispose();
            menuBackground.dispose();
            optionSkin.dispose();
            menuSkin.dispose();
            starMap.dispose();
            atlas.dispose();
        }
    }
