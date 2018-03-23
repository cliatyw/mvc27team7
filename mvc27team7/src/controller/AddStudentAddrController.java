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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		StudentAddrDao dao = new StudentAddrDao();
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		request.setAttribute("studentNo", studentNo);
		
		if(dao.countStudentAddr(studentNo)>=5) {
			
			request.setAttribute("excess", "excess");
			
		}
		/* 주소 입력폼으로 이동 */
		
		request.getRequestDispatcher("/WEB-INF/views/addStudentAddr.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		StudentAddrDao studentaddrdao = new StudentAddrDao();
		if (studentaddrdao.countStudentAddr(studentNo) <= 4) {
			StudentAddr studentaddr = new StudentAddr();
			studentaddr.setStudentNo(studentNo);
			studentaddr.setAddress(request.getParameter("studentAddr"));
			studentaddrdao.insertStudentAddr(studentaddr);
			response.sendRedirect(request.getContextPath() +"/getStudentListAddr.csu?studentNo=" + studentNo);
		}
	}
}
