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

@WebServlet("/getEmployeeController.kks")
public class GetEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Dao 호출  
		//request에 속성 추가  
		//v 로 포워드 
		employeeDao = new EmployeeDao();
		employeeDao.selectEmployee();

		request.getRequestDispatcher("/WEB-INF/views/getEmployeeList.jsp").forward(request, response);
	}

}
