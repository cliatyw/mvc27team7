/*[김기성]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	/**
	 * Employee를 매개변수로하여 값들을 삽입하는 매서드
	 * @param employee
	 */
	public void insertEmployee(Employee employee) {
		
		connection = DriverDao.DriverDbConnection();
		
		String sql = "INSERT INTO employee (employee_no, employee_id, employee_pw) VALUES (NULL, ?, ?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeePw());

			preparedStatement.execute();
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
	public ArrayList<Employee> selectEmployeeList() {
		
		connection = DriverDao.DriverDbConnection();
		
		ArrayList<Employee> list = new ArrayList<>();
		String sql = "SELECT employee_no AS employeeNo, employee_id AS employeeId FROM employee ORDER BY employee_no ASC";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getInt("employeeNo"));
				employee.setEmployeeId(resultSet.getString("employeeId"));
				list.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException e) {}
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
			if (resultSet != null) try { resultSet.close(); } catch(SQLException e) {}
		}
		return list;
	}
	/**
	 * employee를 매개변수로 받아 수정하는 매서드
	 * @param employee
	 */
	public void updateEmployee(Employee employee) {
		
		connection = DriverDao.DriverDbConnection();
		String sql = "UPDATE employee SET employee_id=?, employee_pw=? WHERE employee_no=?";
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeePw());
			preparedStatement.setInt(3, employee.getEmployeeNo());

			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException e) {}
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
		}
	}
	public int deleteEmployee(Employee employee) {
		return 0;
		
	}
}
