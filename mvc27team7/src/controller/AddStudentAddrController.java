/*[최상욱]*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;
@WebServlet("/addStudentAddr.csu")
public class AddStudentAddrController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		StudentAddrDao dao = new StudentAddrDao();
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		request.setAttribute("studentNo", studentNo);
		
		if(dao.countStudentAddr(studentNo)>=5) {
			
			request.setAttribute("addressclick", "addressclick");
			
		}
		/* 주소 입력폼으로 이동 */
		
		request.getRequestDispatcher("/WEB-INF/views/addStudentAddr.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String address = request.getParameter("address");

		StudentAddr studentaddr = new StudentAddr();
		studentaddr.setStudentNo(studentNo);
		studentaddr.setAddress(address);
		StudentAddrDao dao = new StudentAddrDao();
		if (dao.countStudentAddr(studentNo) <= 4) {
			dao.insertStudentAddr(studentaddr);
			response.sendRedirect(request.getContextPath() +"/getStudentListAddr.csu?studentNo=" + studentNo);
		} else {
			response.setContentType("text/html;charset=euc-kr");		
			response.sendRedirect(request.getContextPath() +"/getStudentListAddr.csu?studentNo=" + studentNo);
		
		}
	}
}
