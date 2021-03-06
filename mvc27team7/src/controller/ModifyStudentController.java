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

@WebServlet("/modifyStudent.csu")
public class ModifyStudentController extends HttpServlet {
	private StudentDao dao;
	private Student student;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		int studentNo =Integer.parseInt(request.getParameter("studentNo"));

		student = new Student();
		student.setStudentNo(studentNo);
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		
		dao = new StudentDao();
		dao.updateStudent(student);
		response.sendRedirect("/mvc27team7/getStudentList.csu");
		
	}

}
