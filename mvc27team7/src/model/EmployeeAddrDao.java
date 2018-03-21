/*[김기성]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public int countEmployeeAddr(int employeeNo) {
		Connection connection = DriverDao.DriverDbConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT COUNT(*) FROM employee_addr WHERE employee_no=?";
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeNo);
			
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
	/*
	 * no값을 받아 addr 목록을 list로 넣고 리턴하는 메서드
	 * param employeeNo
	 * return list
	 */
	public ArrayList<EmployeeAddr> selectEmployeeAddrList(int employeeNo){
		Connection connection = DriverDao.DriverDbConnection();
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<EmployeeAddr> list = new ArrayList<>();
		
		String sql = "SELECT address, employee_addr_no AS employeeAddrNo, employee_no AS employeeNo FROM employee_addr WHERE employee_no=? ORDER BY employee_addr_no ASC";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeNo);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				EmployeeAddr employeeAddr = new EmployeeAddr();
				employeeAddr.setAddress(resultSet.getString("address"));
				employeeAddr.setEmployeeAddrNo(resultSet.getInt("employeeAddrNo"));
				employeeAddr.setEmployeeNo(resultSet.getInt("employeeNo"));
				list.add(employeeAddr);
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
	/*
	 * addrNo값을 받아 삭제하는 매서드
	 * param getEmployeeAddrNo
	 */
	public void deleteEmployeeAddr(int getEmployeeAddrNo) {
		PreparedStatement preparedStatement = null;
		
		Connection connection = DriverDao.DriverDbConnection();
		String sql = "DELETE FROM employee_addr WHERE employee_addr_no=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, getEmployeeAddrNo);

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException e) {}
			if (connection != null) try { connection.close(); } catch(SQLException e) {}
		}
	}
}
