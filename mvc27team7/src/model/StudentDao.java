/*[최상욱]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	
	
	public void insertStudent(Student student) {
	
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DriverDao.DriverDbConnection();
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
	
	public ArrayList<Student> selectStudentList(int startRow , int pagePerRow){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<Student> list = new ArrayList<Student>();
		
		try {
			connection = DriverDao.DriverDbConnection();
			statement=connection.prepareStatement("SELECT student_no AS studentNo, student_id AS studentId FROM student ORDER BY student_no ASC limit ?,?");
			statement.setInt(1, startRow);
			statement.setInt(2, pagePerRow);
			rs = statement.executeQuery();
			
			while (rs.next()) {
				Student student = new Student();
				student.setStudentNo(rs.getInt("studentNo"));
				student.setStudentId(rs.getString("studentId"));
				list.add(student);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return list;
	}
	
	public void updateStudent(Student student) {
		Connection connection = null;
		PreparedStatement statement = null;
			try {
				connection = DriverDao.DriverDbConnection();
				statement = connection.prepareStatement("UPDATE student SET student_id=?,student_pw=? WHERE student_no = ?");
				statement.setString(1, student.getStudentId());
				statement.setString(2, student.getStudentPw());
				statement.setInt(3, student.getStudentNo());
				statement.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			
			} finally {
				if (statement != null) try { statement.close(); } catch(SQLException ex) {}
				if (connection != null) try { connection.close(); } catch(SQLException ex) {}
			}
			
		}
	
	public void deleteStudent(int studentNo) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			System.out.println("deleteStudent실행");
			connection = DriverDao.DriverDbConnection();
			statement = connection.prepareStatement("DELETE FROM student WHERE student_no=?");
			statement.setInt(1,studentNo);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (statement != null) try { statement.close(); } catch(SQLException e) {}
		}
	}

	public int countStudent() {
		int count= 0;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try{
		
			connection = DriverDao.DriverDbConnection();
			statement = connection.prepareStatement("SELECT COUNT(*) FROM student");
			rs = statement.executeQuery();
			
		if(rs.next()){
			count=rs.getInt(1);
		}
		}catch(Exception ex){
			System.out.println("getListCount 에러: " + ex);			
		}finally{
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (statement != null) try { statement.close(); } catch(SQLException e) {}
		}
		return count;
	}
	
}