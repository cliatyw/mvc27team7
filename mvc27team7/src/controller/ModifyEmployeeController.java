package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;

/**
 * Servlet implementation class ModifyEmployeeController
 */
@WebServlet("/modifyEmployee.kks")
public class ModifyEmployeeController extends HttpServlet {
	Employee employee = null;
	EmployeeDao employeeDao = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeNo = (String)request.getAttribute("employeeNo");
		request.setAttribute("employeeNo", employeeNo);
		request.getRequestDispatcher("/WEB-INF/views/modifyEmployee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employee = new Employee();
		employee.setEmployeeId(request.getParameter("employeeId"));
		employee.setEmployeeNo(Integer.parseInt(request.getParameter("employeeNo")));
		employee.setEmployeePw(request.getParameter("employeePw"));
		employeeDao = new EmployeeDao();
		employeeDao.updateEmployee(employee);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeController.kks");
	}

}
