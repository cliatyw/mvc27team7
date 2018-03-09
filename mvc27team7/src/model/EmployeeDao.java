/*[김기성]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	/*
	 * Employee클래스를 매개변수로 받아 db에 삽입하는 메서드
	 */
	public void insertEmployee(Employee employee) {
		DriverDao driverDao = new DriverDao();
		String sql = "INSERT INTO employee (employee_no, employee_id, employee_pw) VALUES (NULL, ?, ?)";
		this.connection = driverDao.DriverDbConnection();
		try {
			this.preparedStatement = this.connection.prepareStatement(sql);

			this.preparedStatement.setString(1, employee.getEmployeeId());
			this.preparedStatement.setString(2, employee.getEmployeePw());

			this.preparedStatement.execute();
			this.preparedStatement.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
