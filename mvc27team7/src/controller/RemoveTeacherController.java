/*[김도희]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherDao;

@WebServlet("/removeTeacher.kdh")
public class RemoveTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RemoveTeacherController() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*get방식으로 send_no의 값을 받아온다*/
		String teacher_no = request.getParameter("send_no");
		System.out.println(teacher_no+"<--teacher_no RemoveTeacher");
		/*DAO 삭제메서드 호출*/
		TeacherDao dao = new TeacherDao();
		dao.deleteTeacher(teacher_no);
		response.sendRedirect(request.getContextPath()+"/getTeacherList.kdh");
	}
}
