/*[��⼺]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	/**
	 * EmployeeŬ������ �Ű������� �޾� db�� �����ϴ� �޼���
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
	 * 
	 * @return
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
