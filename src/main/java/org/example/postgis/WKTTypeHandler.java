package org.example.postgis;

import net.postgis.jdbc.PGgeometry;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class WKTTypeHandler<T extends WKTType> extends BaseTypeHandler<T> {

    private static final int SRID_IN_DB = 4326;

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        PGgeometry pGgeometry = new PGgeometry(parameter.getWkt());
        net.postgis.jdbc.geometry.Geometry geometry = pGgeometry.getGeometry();
        geometry.setSrid(SRID_IN_DB);
        ps.setObject(i, pGgeometry);
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String colName) throws SQLException {
        PGgeometry pGgeometry = (PGgeometry) resultSet.getObject(colName);
        return newInstance(pGgeometry.getValue());
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        PGgeometry pGgeometry = (PGgeometry) resultSet.getObject(i);
        return newInstance(pGgeometry.getValue());
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        PGgeometry pGgeometry = (PGgeometry) callableStatement.getObject(i);
        return newInstance(pGgeometry.getValue());
    }



    abstract T newInstance(String wkt);
}
