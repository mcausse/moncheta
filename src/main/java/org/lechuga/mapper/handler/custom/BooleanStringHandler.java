package org.lechuga.mapper.handler.custom;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.lechuga.jdbc.ResultSetUtils;
import org.lechuga.mapper.handler.Handler;

public class BooleanStringHandler implements Handler {

    final String vtrue;
    final String vfalse;

    public BooleanStringHandler(final String vtrue, final String vfalse) {
        super();
        this.vtrue = vtrue;
        this.vfalse = vfalse;
    }

    public BooleanStringHandler() {
        this("T", "F");
    }

    @Override
    public Object getJdbcValue(Object v) {
        if (v == null) {
            return null;
        }
        return (Boolean) v ? vtrue : vfalse;
    }

    @Override
    public Object readValue(ResultSet rs, String columnName) throws SQLException {
        String v = ResultSetUtils.getString(rs, columnName);
        if (v == null) {
            return null;
        }
        return vtrue.equals(v);
    }

}
