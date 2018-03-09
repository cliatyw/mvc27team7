/*[±è±â¼º]*/
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDao {
	public Connection DriverDbConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String jdbcDriver = "jdbc:mysql://localhost:3306/root?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
