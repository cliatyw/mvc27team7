/*[김도희]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherAddrDao {
	/*teacher_no,address추가*/
	public void insertTeacherAddr(TeacherAddr teacherAddr) {
		PreparedStatement statement = null;
		Connection connection = null;
		
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
	/*teacher address개수 구하는것으로써 리턴형은 int*/
	public int countTeacherAddr(int teacher_no) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultset = null;
		
		int count=0;
		connection = DriverDao.DriverDbConnection();
		String sql = "SELECT count(*) FROM teacher_addr WHERE teacher_no=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1,teacher_no);
			resultset = statement.executeQuery();
			while(resultset.next()) {
				count= Integer.parseInt(resultset.getString("count(*)"));
				System.out.println(count+"<--count countTeacherAddr");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/*해당teacher_no의 전체list조회로써 리턴형은 list배열*/ 
	public ArrayList<TeacherAddr> selectTeacherAddrList(int teacher_no) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultset = null;
		
		ArrayList<TeacherAddr> list = new ArrayList<TeacherAddr>();
		connection = DriverDao.DriverDbConnection();
		String sql = "SELECT * FROM teacher_addr WHERE teacher_no=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, teacher_no);
			resultset = statement.executeQuery();
			while(resultset.next()) {
				System.out.println("해당teacher_no의 전체list조회 실행");
				TeacherAddr teacheraddr = new TeacherAddr();
				teacheraddr.setTeacherAddrNo(resultset.getInt("teacher_addr_no"));
				teacheraddr.setTeacherNo(resultset.getInt("teacher_no"));
				teacheraddr.setAddress(resultset.getString("address"));
				list.add(teacheraddr);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} return list;
	}
	/*체크되었던 값들 addr_no들을 매개변수로 받고 주소삭제*/
	public void deleteTeacherAddr(int list) {
		PreparedStatement statement = null;
		Connection connection = null;
		
		connection = DriverDao.DriverDbConnection();
		String sql = "DELETE FROM teacher_addr WHERE teacher_addr_no=?";		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1,list);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (statement != null) try { statement.close(); } catch(SQLException e) {}
		}
	}
	/*주소값이 있는지 없는지 검색*/
	public TeacherAddr selectTeacherAddr(int teacher_no) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultset = null;
		TeacherAddr teacheraddr = new TeacherAddr();
		
		connection = DriverDao.DriverDbConnection();
		
		String sql = "SELECT address FROM teacher_addr WHERE teacher_no=?";
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, teacher_no);
			resultset = statement.executeQuery();	
			while(resultset.next()) {				
				teacheraddr.setAddress(resultset.getString("address"));
				System.out.println(resultset.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try { statement.close(); } catch(SQLException e) {}
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (resultset != null) try { resultset.close(); } catch(SQLException e) {}
		} return teacheraddr;
	}
}
