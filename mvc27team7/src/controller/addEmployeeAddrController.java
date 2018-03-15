/*[김기성]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;

@WebServlet("/addEmployeeAddr.kks")
public class addEmployeeAddrController extends HttpServlet {
	
	private EmployeeAddrDao employeeAddrDao = null;
	//no값만 받아 주소입력창으로 이동한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/addEmployeeAddr.jsp").forward(request, response);
	}
	//입력받은 주소값을 db에 저장한다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		EmployeeAddr employeeAddr = new EmployeeAddr();
		employeeAddr.setEmployeeNo(Integer.parseInt(request.getParameter("employeeNo")));
		employeeAddr.setAddress(request.getParameter("employeeAddr"));
		
		employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.insertEmployeeAddr(employeeAddr);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeController.kks");
	}
}
