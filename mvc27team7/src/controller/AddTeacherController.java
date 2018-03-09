/*[±èµµÈñ]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;
import model.TeacherDao;

@WebServlet("/addTeacher.kdh")
public class AddTeacherController extends HttpServlet {
	private TeacherDao teacherdao;
	private Teacher teacher;
	//teacher ÀÔ·Â Æû¿äÃ»
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request,response);
	}
	//guest ÀÔ·Â
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		System.out.println(teacherId+"<--teacherId");
		System.out.println(teacherPw+"<--teacherPw");
		
		this.teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		//guest setterÈ£Ãâ
		this.teacherdao = new TeacherDao();
		teacherdao.insertTeacher(teacher);
		response.sendRedirect(request.getContextPath()+"/getTeacherList.kdh");
	}
}
