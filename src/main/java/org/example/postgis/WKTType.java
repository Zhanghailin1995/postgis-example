package org.example.postgis;

public abstract class WKTType {

    protected String wkt;

    public WKTType(String wkt) {
        this.wkt = wkt;
    }

    public String getWkt() {
        return wkt;
    }

    public void setWkt(String wkt) {
        this.wkt = wkt;
    }
}
