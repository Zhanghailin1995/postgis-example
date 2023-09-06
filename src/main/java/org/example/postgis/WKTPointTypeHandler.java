package org.example.postgis;


public class WKTPointTypeHandler extends WKTTypeHandler<WKTPointType> {

    @Override
    WKTPointType newInstance(String wkt) {
        return new WKTPointType(wkt);
    }
}
