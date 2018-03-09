/*[김도희]*/
package model;

import model.DriverDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

public class TeacherDao {
	PreparedStatement statement = null;
	Connection connection = null;
	ResultSet resultset = null;
	/*teacher의id,pw를 INSERT쿼리문을 사용하여 추가하는 메소드*/
	public void insertTeacher(Teacher teacher) {	
		connection = DriverDao.DriverDbConnection();
				
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
	/*teacher(no,id,pw)의 전체list를 조회하는 메소드로써 teacher의 no,id,pw의 값을 담은 list배열을 리턴한다*/
	public ArrayList<Teacher> selectTeacherList() {
		connection = DriverDao.DriverDbConnection();
		ArrayList<Teacher> list = new ArrayList();
		
		String sql = "SELECT *FROM teacher ORDER BY teacher_no ASC";
		
		try {
			statement = connection.prepareStatement(sql);
			resultset = statement.executeQuery();
			
			while(resultset.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherNo(resultset.getInt("teacher_no"));
				teacher.setTeacherId(resultset.getString("teacher_id"));
				teacher.setTeacherPw(resultset.getString("teacher_pw"));
				System.out.println(resultset.getInt("teacher_no"));
				System.out.println(resultset.getString("teacher_id"));
				System.out.println(resultset.getString("teacher_pw"));
				
				list.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException e) {}
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (resultset != null) try { resultset.close(); } catch(SQLException e) {}
		} return list;
	}
	
}
