package group4.util;

import java.sql.*;

public class DBCon {
    public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String URL = "jdbc:sqlserver://guiyu.database.windows.net:1433;databaseName=test";
    public static final String USER = "guiyu";
    public static final String PWD = "2021test**";
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public DBCon() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        try {
            con = DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeAll() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null)
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


    public int update(String sql, Object... pras) {
        int resu = 0;
        con = getCon();
        try {
            ps = con.prepareStatement(sql);
            if (pras != null) {
                for (int i = 0; i < pras.length; i++) {
                    ps.setObject(i + 1, pras[i]);
                }
            }
            resu = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return resu;
    }


    public ResultSet query(String sql, Object... pras) {
        con = getCon();
        try {
            ps = con.prepareStatement(sql);
            if (pras != null) {
                for (int i = 0; i < pras.length; i++) {
                    ps.setObject(i + 1, pras[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
