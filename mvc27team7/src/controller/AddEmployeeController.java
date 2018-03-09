/*[��⼺]*/
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
		 * 1.requestó��
		 * 2.��daoȣ��
		 * 3.�ٸ� ��Ʈ�ѷ� ȣ��
		 */
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		//guest setter ȣ��
		//dao
		
		response.sendRedirect("/getEmployeeController.kks");
	}

}
