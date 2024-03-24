package nitin.JDBC;

import java.sql.*;

/**
 * Created by Nitin C on 3/4/2016.
 */
public class BasicConnection {
    public static void main(String[] args) throws SQLException {

        //final String DB_URL = "//localhost:3306/test";
        //To avoid java.sql.SQLException: The server timezone value 'UTC' is unrecognized
        //?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        // SET GLOBAL time_zone = '+3:00';
        final String DB_URL = "//localhost:3306/HabitTracking?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String USER = "root";
        final String PASSWORD = "root";

        final String QUERY = "select * from habit";

        // 1. Register the Class (Get Driver name)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. Create Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql:" + DB_URL, USER, PASSWORD);

        // 3. Create Query
        PreparedStatement ps = conn.prepareStatement(QUERY);
        //ps.setString(1,"id");

        // 4. Execute statement
        ResultSet rs = ps.executeQuery();

        //Traverse through the Cursor
        //if (rs.next()){ //To Print just one row
        while (rs.next()) {
            //Traverse through the iterator.
            int e_id = rs.getInt(1);
            String e_name = rs.getString(2);

            System.out.println(e_id + " - " + e_name);
        }
        // 5. Close Connection
        ps.close();
        rs.close();
        conn.close();
    }
}