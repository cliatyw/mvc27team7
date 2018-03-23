/*[최상욱]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentAddr;
import model.StudentAddrDao;
import model.StudentDao;
@WebServlet("/getStudentListAddr.csu")
public class GetStudentAddrListController extends HttpServlet {
	
	private StudentAddrDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	int studentNo = Integer.parseInt(request.getParameter("studentNo"));

	dao = new StudentAddrDao();

	request.setAttribute("studentNo", studentNo);
	request.setAttribute("list", dao.selectStudentAddrList(studentNo));
	request.getRequestDispatcher("/WEB-INF/views/getStudentAddrList.jsp").forward(request, response);
	}
}