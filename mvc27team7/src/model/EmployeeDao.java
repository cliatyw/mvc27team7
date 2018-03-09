/*[김기성]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	/**
	 * Employee를 매개변수로하여 값들을 삽입하는 매서드
	 * @param employee
	 */
	public void insertEmployee(Employee employee) {
		
		String sql = "INSERT INTO employee (employee_no, employee_id, employee_pw) VALUES (NULL, ?, ?)";
		connection = DriverDao.DriverDbConnection();
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
	/**
	 * db에 있는 목록을 불러와 list로 리턴하는 매서드
	 * @return list
	 */
	public ArrayList<Employee> selectEmployee() {
		
		String sql = "SELECT employee_id AS employeeId, employee_pw AS employeePw FROM employee";
		connection = DriverDao.DriverDbConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
