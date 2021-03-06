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

@WebServlet("/addStudent.csu")
public class AddStudentController extends HttpServlet {

	private Student student;
	private StudentDao dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		
		student = new Student();
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		
		dao = new StudentDao();
		dao.insertStudent(student);
		response.sendRedirect(request.getContextPath() + "/getStudentList.csu");
		
	}

}