/*[김기성]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private DriverDao driverDao = null;
	/*
	 * Employee클래스를 매개변수로 받아 db에 삽입하는 메서드
	 */
	public void insertEmployee(Employee employee) {
		driverDao = new DriverDao();
		String sql = "INSERT INTO employee (employee_no, employee_id, employee_pw) VALUES (NULL, ?, ?)";
		connection = driverDao.DriverDbConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeePw());

			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException e) {}
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
		}
	}
	public ArrayList<Employee> selectEmployee() {
		driverDao = new DriverDao();
		String sql = "SELECT employee_id AS employeeId, employee_pw AS employeePw FROM employee";
		connection = driverDao.DriverDbConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
