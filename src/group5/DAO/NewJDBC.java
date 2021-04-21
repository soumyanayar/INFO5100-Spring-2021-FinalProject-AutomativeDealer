package group5.DAO;
import java.sql.*;

public class NewJDBC {
    private static final String URL
            = "jdbc:sqlserver://guiyu.database.windows.net:1433;databaseName=test";
    private static final String USERNAME = "guiyu"; //For personal test, will replace it later
    private static final String PASSWORD = "2021test**";

    private Connection conn;
    private static NewJDBC _instance;
    private Statement stmt;

    static public NewJDBC getInstance() throws SQLException, ClassNotFoundException {
        if (_instance == null) {
            _instance = new NewJDBC();
        }
        return _instance;
    }

    private NewJDBC() throws SQLException, ClassNotFoundException {
        //Need to download Microsoft JDBC Driver for SQL Server
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("connected");
        this.stmt = conn.createStatement();
    }

    private PreparedStatement prepareStatement(String sql, String[] params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stmt.setString(i + 1 , params[i]);
        }
        return stmt;
    }
    
    public ResultSet getAllDealers() throws SQLException{
        return stmt.executeQuery("select * from Dealer");
    }
    
    public ResultSet getAllCars() throws SQLException{
        return stmt.executeQuery("select * from NewVehicleData");
    }
    
    public void getAllRows() throws SQLException{
        ResultSet rs = stmt.executeQuery("select * from NewVehicleData");
        while(rs.next()){
            for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                System.out.print(rs.getString(i) + "  ");
            }
            System.out.println();
        }
    }
    
    public int getNumColumns() throws SQLException{
        ResultSet rs = stmt.executeQuery("select * from Dealers");
        return rs.getMetaData().getColumnCount();
    }
    
    public void printColumnInfo() throws SQLException{
        ResultSet rs = stmt.executeQuery("select * from NewVehicleData");
        ResultSetMetaData metadata = rs.getMetaData();
        for(int col = 1; col <= metadata.getColumnCount(); col++){
            String colName = metadata.getColumnName(col);
            String type = metadata.getColumnTypeName(col);
            System.out.println(colName + " has data type " + type);
        }
    }
    
    public void getNumRows() throws SQLException{
        ResultSet rs = stmt.executeQuery("select count(*) from Dealers");
        rs.next();
        System.out.println("Dealer Table has " + rs.getInt(1) + " rows");
    }

    public ResultSet query(String sql, String[] params) throws SQLException {
        return prepareStatement(sql, params).executeQuery();
    }

    public int update(String sql, String[] params) throws SQLException {
        return prepareStatement(sql, params).executeUpdate();
    }
    public ResultSet getResults(String query) {
        ResultSet rs = null;
        try {
            // stmt is the connection statement
            // System.out.println("select sql query: " + query);
            rs = this.stmt.executeQuery(query);
            /**
             *
             * rs = this.stmt.executeQuery("select * from dbo.CustomerRequest"); while
             * (rs.next()) { System.out.println(rs.getString("leadId") +
             * rs.getString("firstName")); }
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public int updateOldversion(String sql) {
        try {
            // System.out.println("update sql query: " + sql);
            return this.stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		NewJDBC obj = new NewJDBC();
		obj.getAllCars();
		
	}

}
