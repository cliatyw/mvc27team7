package model;

public class StudentAddr {
	private int student_addr_no;
	private int student_no;
	private String address;
	
	
	public int getStudent_addr_no() {
		return student_addr_no;
	}
	public void setStudent_addr_no(int student_addr_no) {
		this.student_addr_no = student_addr_no;
	}
	public int getStudent_no() {
		return student_no;
	}
	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentAddr [student_addr_no=" + student_addr_no + ", student_no=" + student_no + ", address=" + address + "]";
	}
	
}
