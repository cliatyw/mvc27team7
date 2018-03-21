package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAddrDao {
	public void insertStudentAddr(StudentAddr studentaddr) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DriverDao.DriverDbConnection();
			statement=connection.prepareStatement("INSERT INTO student_addr(student_no, address) VALUES (?, ?)");
			statement.setInt(1, studentaddr.getStudentNo());
			statement.setString(2, studentaddr.getAddress());
			statement.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
	}
	
	public int countStudentAddr(int studentNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		int count = 0;
		try {
		connection = DriverDao.DriverDbConnection();
		statement=connection.prepareStatement("select count(student_no) from student_addr Where student_no= ?;");
		statement.setInt(1, studentNo);		
		rs = statement.executeQuery();
		while (rs.next()) {
			count=Integer.parseInt(rs.getString("count(student_no)"));
		}	
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return count;
	}
	
	public ArrayList<StudentAddr> selectStudentAddrList(int studentNo){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<StudentAddr> list = new ArrayList<StudentAddr>();

		try {
			connection = DriverDao.DriverDbConnection();
			statement=connection.prepareStatement("select * from student_addr Where student_no= ?");
			statement.setInt(1, studentNo);		

			rs = statement.executeQuery();
			
			while (rs.next()) {
				StudentAddr studentAddr = new StudentAddr();
				studentAddr.setStudentAddrNo(rs.getInt("student_addr_no"));
				studentAddr.setStudentNo(rs.getInt("student_no"));
				studentAddr.setAddress(rs.getString("address"));
				list.add(studentAddr);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return list;
	}
	
	public void deleteStudent(String student_addr_no) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			System.out.println("deleteStudent실행");
			connection = DriverDao.DriverDbConnection();
			statement = connection.prepareStatement("DELETE FROM student_addr WHERE student_addr_no=?");
			statement.setString(1,student_addr_no);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (statement != null) try { statement.close(); } catch(SQLException e) {}
		}
	}
	
}
