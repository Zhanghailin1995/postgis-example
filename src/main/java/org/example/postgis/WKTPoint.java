package org.example.postgis;


public class WKTPoint {

    public WKTPoint(String wkt) {
        this.wkt = wkt;
    }

    public WKTPoint() {
    }

    private String wkt;

    public String getWkt() {
        return wkt;
    }

    public void setWkt(String wkt) {
        this.wkt = wkt;
    }
}
