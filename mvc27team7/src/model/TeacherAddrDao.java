/*[김도희]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherAddrDao {
	PreparedStatement statement = null;
	Connection connection = null;
	ResultSet resultset = null;
	/*teacher_no,address추가하는 주소메서드*/
	public void insertTeacherAddr(TeacherAddr teacherAddr) {
		connection = DriverDao.DriverDbConnection();
		String sql = "INSERT INTO teacher_addr(teacher_no, address) VALUES (?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1,teacherAddr.getTeacherNo());
			statement.setString(2,teacherAddr.getAddress());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
