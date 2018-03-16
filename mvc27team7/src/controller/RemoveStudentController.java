package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDao;
import model.TeacherDao;
@WebServlet("/removeStudent.csu")
public class RemoveStudentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentNo = request.getParameter("studentNo");
		System.out.println(studentNo+"<--StudentNo RemoveStudentController");
		
		StudentDao dao = new StudentDao();
		dao.deleteStudent(studentNo);
		response.sendRedirect(request.getContextPath()+"/getStudentList.csu");
	}
}
