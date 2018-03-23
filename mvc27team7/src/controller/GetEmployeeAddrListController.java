package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;

@WebServlet("/getEmployeeAddrList.kks")
public class GetEmployeeAddrListController extends HttpServlet {
	private EmployeeAddrDao employeeAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		
		employeeAddrDao = new EmployeeAddrDao();
		
		//request에 no와 no에 해당하는 addr list를 세팅한다.
		request.setAttribute("employeeNo", employeeNo);
		request.setAttribute("list", employeeAddrDao.selectEmployeeAddrList(employeeNo));
		
		request.getRequestDispatcher("/WEB-INF/views/getEmployeeAddrList.jsp").forward(request, response);
	}
}
