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
public class addEmployeeAddrController extends HttpServlet {
	
	private EmployeeAddrDao employeeAddrDao = null;
	//no값만 받아 주소입력창으로 이동한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		employeeAddrDao = new EmployeeAddrDao();
		String employeeNo = request.getParameter("employeeNo");
		if(employeeAddrDao.countEmployeeAddr(employeeNo)>=5) {
			
			request.setAttribute("disabled", "disabled");
			
		}
		request.getRequestDispatcher("/WEB-INF/views/addEmployeeAddr.jsp").forward(request, response);
	}
	//입력받은 주소값을 db에 저장한다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		employeeAddrDao = new EmployeeAddrDao();
		String employeeNo = request.getParameter("employeeNo");
		if(employeeAddrDao.countEmployeeAddr(employeeNo)<=5) {
			EmployeeAddr employeeAddr = new EmployeeAddr();
			employeeAddr.setEmployeeNo(Integer.parseInt(employeeNo));
			employeeAddr.setAddress(request.getParameter("employeeAddr"));
			
			employeeAddrDao.insertEmployeeAddr(employeeAddr);
			
			response.sendRedirect(request.getContextPath() + "/getEmployeeController.kks");
		}else {
			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('주소를 5개 초과했습니다');");
	   		out.println("location.href='" + request.getContextPath() + "/getEmployeeController.kks';");
	   		out.println("</script>");
	   		out.close();
	   		
		}
	}
}
