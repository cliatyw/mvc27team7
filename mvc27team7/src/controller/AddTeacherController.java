/*[김도희]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;
import model.TeacherDao;

@WebServlet("/addTeacher.kdh")
public class AddTeacherController extends HttpServlet {	
	//teacher 입력폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("euc-kr");
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request,response);
	}
	//teacher 입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");	
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		System.out.println(teacherId+"<--teacherId");
		System.out.println(teacherPw+"<--teacherPw");
		
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		
		TeacherDao teacherdao = new TeacherDao();
		teacherdao.insertTeacher(teacher);
		response.sendRedirect(request.getContextPath()+"/getTeacherList.kdh");
	}
}
