package org.faldmo.astralia.screens;

import com.badlogic.gdx.graphics.Mesh;

import org.faldmo.astralia.Astralia;
import org.faldmo.astralia.org.faldmo.astralia.domain.City;

public class MenuScreen extends AbstractScreen {
    Mesh mesh;
    Array<City> cities;

    public MenuScreen(Astralia as) {
        super(as);
    }


    public String getLongitude() {
        return (name + " longitude" + degLong + " " + minLong);
    }

    public String getLatitude() {
        return (name + " latitude: " + degLat + " " + minLat);
    }
}