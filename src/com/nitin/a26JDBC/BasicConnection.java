package com.nitin.a26JDBC;

import java.sql.*;

/**
 * Created by Nitin C on 3/4/2016.
 */
public class BasicConnection {
    public static void main(String[] args) throws SQLException {

        // 1. Register the Class (Get Driver name)
        try {
            Class.forName("com.mysql.jdbc.driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. Create Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDBName", "uName", "password");

        // 3. Create Query
        PreparedStatement ps = conn.prepareStatement("Select * from Emp where id=? And password=?");
		ps.setString(1,"id");

		// 4. Execute statement
		ResultSet rs = ps.executeQuery();

		//Traverse through the Cursor
		if (rs.next()){
		    //Traverse through the iterator.
            int user_id = rs.getInt("user_id");
            String password = rs.getString("password");

        }

		// 5. Close Connection
		conn.close();
    }
}
