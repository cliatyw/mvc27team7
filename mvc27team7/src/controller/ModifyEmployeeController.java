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

@WebServlet("/modifyEmployee.kks")
public class ModifyEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao = null;
	//no값만 받아 수정화면으로 간다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}
	//수정화면에서 수정한 값을 입력하여 수정한 후 리스트화면으로 간다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Employee employee = new Employee();
		employee.setEmployeeId(request.getParameter("employeeId"));
		employee.setEmployeeNo(Integer.parseInt(request.getParameter("employeeNo")));
		employee.setEmployeePw(request.getParameter("employeePw"));
		employeeDao = new EmployeeDao();
		//employee를 매개변수로 받아 수정하는 매서드를 실행한다.
		employeeDao.updateEmployee(employee);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.kks");
	}

}
