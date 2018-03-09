/*[최상욱]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;
@WebServlet("/getStudentList.csu")
public class GetStudentListController extends HttpServlet {
	
	private StudentDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	this.dao = new StudentDao();
		
	request.setAttribute("list", dao.selectStudentList());	
	request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
	}
}