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
	private static final long serialVersionUID = 1L;
	private Student student;
	private StudentDao dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		
		this.student = new Student();
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		
		this.dao = new StudentDao();
		dao.insertStudent(student);
		response.sendRedirect("/mvc27team7/getStudentList.csu");
		
	}

}