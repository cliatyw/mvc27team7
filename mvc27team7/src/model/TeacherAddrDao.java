/*[김도희]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	/*teacher address개수 구하는 메소드*/
	public int countTeacherAddr(int teacher_no) {
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
	/*address 전체list를 조회하는 메소드*/ 
	public ArrayList<TeacherAddr> selectTeacherAddrList() {
		ArrayList<TeacherAddr> list = new ArrayList<TeacherAddr>();
		connection = DriverDao.DriverDbConnection();
		String sql = "SELECT * FROM teacher_addr";
		try {
			statement = connection.prepareStatement(sql);
			resultset = statement.executeQuery();
			while(resultset.next()) {
				System.out.println("address 전체list를 조회하는 메소드 실행");
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
}
