/*[김기성]*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;

@WebServlet("/addEmployeeAddr.kks")
public class AddEmployeeAddrController extends HttpServlet {
	
	private EmployeeAddrDao employeeAddrDao = null;
	//no값만 받아 주소입력창으로 이동한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		employeeAddrDao = new EmployeeAddrDao();
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		//5개 이상일시 request에 disabled을 셋팅한다.
		if(employeeAddrDao.countEmployeeAddr(employeeNo)>=5) {
			
			request.setAttribute("excess", "excess");
			
		}
		request.getRequestDispatcher("/WEB-INF/views/addEmployeeAddr.jsp").forward(request, response);
	}
	//입력받은 주소값을 db에 저장한다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		employeeAddrDao = new EmployeeAddrDao();
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		//5개 이하일때만 삽입
		if(employeeAddrDao.countEmployeeAddr(employeeNo)<5) {
			EmployeeAddr employeeAddr = new EmployeeAddr();
			employeeAddr.setEmployeeNo(employeeNo);
			employeeAddr.setAddress(request.getParameter("employeeAddr"));
			
			employeeAddrDao.insertEmployeeAddr(employeeAddr);
			
			response.sendRedirect(request.getContextPath() + "/getEmployeeAddrList.kks?employeeNo=" + employeeNo);
		}
	}
}
