/*[김기성]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;

@WebServlet("/addEmployee.kks")
public class AddEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao = null;
	private Employee employee = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*  
		* 1.request처리  
		* 2.모델dao호출  
		* 3.다른 컨트롤러 호출  
		*/  

		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		
		employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeePw(employeePw);
		
		employeeDao = new EmployeeDao();
		//아이디와 비밀번호를 입력받은 값을 employee객체에 넣어 그 객체를 매개변수로 하여 삽입 매서드를 실행시킨다.
		employeeDao.insertEmployee(employee);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeController.kks");
	}

}
