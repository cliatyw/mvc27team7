/*[김도희]*/
package controller;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;
import model.TeacherDao;


@WebServlet("/modifyTeacher.kdh")
public class ModifyTeacherController extends HttpServlet {
    /*send_no의 값을 받아와 forward로 수정화면폼으로 이동한다*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("euc-kr");
    	/*get방식으로 teacher_no의 값을 받아온다*/
    	String teacher_no = request.getParameter("send_no");
		System.out.println(teacher_no+"<--teacher_no ModifyTeacher");
		request.setAttribute("teacher_no", teacher_no);
		/*수정화면 폼*/
		request.getRequestDispatcher("/WEB-INF/views/modifyTeacher.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("doPost ModifyTeacherController");
		/*수정화면의 teacher id와 pw의 값을 받아온다*/
		String teacher_id = request.getParameter("teacherId");
		String teacher_pw= request.getParameter("teacherPw");
		int teacher_no =Integer.parseInt(request.getParameter("teacherNo"));
		System.out.println(teacher_id+"<--teacher_id ModifyTeacherController");
		System.out.println(teacher_pw+"<--teacher_pw ModifyTeacherController");
		System.out.println(teacher_no+"<--teacher_no ModifyTeacherController");
		/*수정화면에서 받아온값 teacher no,id,pw를 Teacher에 세팅해준다*/
		Teacher teacher = new Teacher();
		teacher.setTeacherNo(teacher_no);
		teacher.setTeacherId(teacher_id);
		teacher.setTeacherPw(teacher_pw);
		/*Dao수정처리메소드호출*/
		TeacherDao dao = new TeacherDao();
		dao.updateTeacher(teacher);
		response.sendRedirect(request.getContextPath()+"/getTeacherList.kdh");
	}

}
