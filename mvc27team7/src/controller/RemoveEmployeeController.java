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
	//no받아 삭제후 list화면으로 간다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		employeeDao = new EmployeeDao();
		employeeDao.deleteEmployee(employeeNo);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.kks");
	}
}
