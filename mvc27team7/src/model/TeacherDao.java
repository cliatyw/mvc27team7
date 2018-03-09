/*[�赵��]*/
package model;

import model.DriverDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class TeacherDao {
	PreparedStatement statement = null;
	Connection connection = null;
	/*teacher�� id, pw�� INSERT�������� �̿��Ͽ� �߰��ϴ� �޼ҵ�*/
	public void insertTeacher(Teacher teacher) {	
		DriverDao driverdao = new DriverDao();
		connection = driverdao.DriverDbConnection();
				
		String sql = "INSERT INTO teacher(teacher_id, teacher_pw)VALUES (?, ?)";
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, teacher.getTeacherId());
			statement.setString(2, teacher.getTeacherPw());
			statement.executeUpdate();
			System.out.println(teacher.getTeacherId());
			System.out.println(teacher.getTeacherPw());			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException e) {}
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
		}
	}
}
