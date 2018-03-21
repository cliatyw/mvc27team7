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
		PreparedStatement statement = null;
		Connection connection = null;
		
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
	/*teacher(no,id)의 전체list를 조회하는 메소드로써 teacher의 no,id의 값을 담은 list배열을 리턴한다*/
	public ArrayList<Teacher> selectTeacherList() {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultset = null;
		
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
				System.out.println(resultset.getInt("teacher_no"));
				System.out.println(resultset.getString("teacher_id"));
				
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
	/*해당 teacher_no의 id와 pw의값을 수정하는 메소드*/
	public void updateTeacher(Teacher teacher) {
		PreparedStatement statement = null;
		Connection connection = null;
		
		connection = DriverDao.DriverDbConnection();
		String sql = "UPDATE teacher SET teacher_id=?,teacher_pw=? WHERE teacher_no=?";	
		try {
			System.out.println("수정처리 메소드 실행");
			statement = connection.prepareStatement(sql);
			statement.setString(1, teacher.getTeacherId());
			statement.setString(2, teacher.getTeacherPw());
			statement.setInt(3, teacher.getTeacherNo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (statement != null) try { statement.close(); } catch(SQLException e) {}
		}
	}
	/*teacher_no의 값을 매개변수로 가져와 삭제처리하는 메서드*/
	public void deleteTeacher(String teacher_no) {
		PreparedStatement statement = null;
		Connection connection = null;
		
		connection = DriverDao.DriverDbConnection();
		String sql = "DELETE FROM teacher WHERE teacher_no=?";		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,teacher_no);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (statement != null) try { statement.close(); } catch(SQLException e) {}
		}
	}
}
