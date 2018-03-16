/*[김기성]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAddrDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	/**
	 * EmployeeAddr 매개변수로 받아 주소를 입력하는 메서드
	 * @param employeeAddr
	 */
	public void insertEmployeeAddr(EmployeeAddr employeeAddr) {
		connection = DriverDao.DriverDbConnection();
		
		String sql = "INSERT INTO employee_addr(employee_addr_no, employee_no, address) VALUES (NULL, ?, ?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, employeeAddr.getEmployeeNo());
			preparedStatement.setString(2, employeeAddr.getAddress());

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException e) {}
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
		}
	}
	public int countEmployeeAddr(String employeeNo) {
		connection = DriverDao.DriverDbConnection();
		
		String sql = "SELECT COUNT(employee_no) FROM employee_addr WHERE employee_no=?";
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employeeNo);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				count = resultSet.getInt("COUNT(employee_no)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException e) {}
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (resultSet != null) try { resultSet.close(); } catch(SQLException e) {}
		}
		return count;
	}
}
