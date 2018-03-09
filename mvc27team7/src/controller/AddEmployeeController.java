/*[김기성]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDao;

@WebServlet("/addEmployee.kks")
public class AddEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao;
	
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
		//guest setter 호출
		//dao
		
		response.sendRedirect("/getEmployeeController.kks");
	}

}
