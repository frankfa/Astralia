package org.faldmo.astralia.org.faldmo.astralia.domain;

public class City {
    public String name;
    public String region;
    public int degLong = 0;
    public int minLong = 0;
    public int degLat = 0;
    public int minLat = 0;

    public City(String name) {
        this.name = name;
    }

    	public String getLongitude(){
		return (name+" longitude"+degLong+" "+minLong);
	}

	public String getLatitude() {
		return (name+" latitude: "+degLat+" "+minLat);
	}

}
