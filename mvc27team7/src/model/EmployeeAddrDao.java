/*[김기성]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeAddrDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
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
}
