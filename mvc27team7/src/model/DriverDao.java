/*[김기성]*/
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDao {

	/**
	 * db연결하는 매서드
	 * @return connection
	 */
	public static Connection DriverDbConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String jdbcDriver = "jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=euckr";
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
