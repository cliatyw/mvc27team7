/*[ÃÖ»ó¿í]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
	
	
	public void insertStudent(Student student) {
	
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			DriverDao driver = new DriverDao();
			connection = driver.DriverDbConnection();
			statement=connection.prepareStatement("INSERT INTO student(student_id, student_pw) VALUES (?, ?)");
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getStudentPw());
			statement.executeUpdate();			
			
			} catch (SQLException e) {
				e.printStackTrace();
			
			} finally {
				if (statement != null) try { statement.close(); } catch(SQLException ex) {}
				if (connection != null) try { connection.close(); } catch(SQLException ex) {}
			}
		}
}