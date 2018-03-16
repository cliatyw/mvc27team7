/*[김기성]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAddrDao {
	/*
	 * EmployeeAddr 매개변수로 받아 주소를 입력하는 메서드
	 * param employeeAddr
	 */
	public void insertEmployeeAddr(EmployeeAddr employeeAddr) {
		Connection connection = DriverDao.DriverDbConnection();
		
		String sql = "INSERT INTO employee_addr(employee_addr_no, employee_no, address) VALUES (NULL, ?, ?)";
		PreparedStatement preparedStatement= null;
		
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
	/*
	 * no를 매개변수로 받아 해당하는 갯수를 세고 count로 리턴받는 매서드
	 * param employeeNo
	 * return count
	 */
	public int countEmployeeAddr(String employeeNo) {
		Connection connection = DriverDao.DriverDbConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT COUNT(*) FROM employee_addr WHERE employee_no=?";
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employeeNo);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				count = resultSet.getInt("COUNT(*)");
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
