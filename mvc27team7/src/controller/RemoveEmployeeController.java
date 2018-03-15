/*[김기성]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDao;

@WebServlet("/removeEmployee.kks")
public class RemoveEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeNo = request.getParameter("employeeNo");
		employeeDao = new EmployeeDao();
		employeeDao.deleteEmployee(employeeNo);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeController.kks");
	}
}
