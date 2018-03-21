package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddrDao;

@WebServlet("/removeEmployeeAddr.kks")
public class RemoveEmployeeAddrController extends HttpServlet {
	private EmployeeAddrDao employeeAddrDao=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] checkList = request.getParameterValues("getEmployeeAddrNo");
		
		System.out.println(request.getAttribute("employeeNo"));
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		
		int checkListNo = 0;
		employeeAddrDao = new EmployeeAddrDao();
		
		for(int i=0; checkList.length>i; i++) {
			checkListNo = Integer.parseInt(checkList[i]);
			employeeAddrDao.deleteEmployeeAddr(checkListNo);
		}
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeAddrList.kks?employeeNo=" + employeeNo);
	}

}
