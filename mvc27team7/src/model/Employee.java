/*[±è±â¼º]*/
package model;

public class Employee {
	private int EmployeeNo;
	private String EmployeeId;
	private String EmployeePw;
	
	public int getEmployeeNo() {
		return EmployeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		EmployeeNo = employeeNo;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeePw() {
		return EmployeePw;
	}
	public void setEmployeePw(String employeePw) {
		EmployeePw = employeePw;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeNo=" + EmployeeNo + ", EmployeeId=" + EmployeeId + ", EmployeePw=" + EmployeePw + "]";
	}
	
}
