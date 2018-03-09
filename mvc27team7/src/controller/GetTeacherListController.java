/*[김도희]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TeacherDao;
import java.util.ArrayList;
import model.Teacher;

@WebServlet("/getTeacherList.kdh")
public class GetTeacherListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		/*request에 teacher의 no,id,pw값을 담은후 getTeacherList.jsp에 넘겨준다*/
		TeacherDao teacherdao = new TeacherDao();
		request.setAttribute("teacherList", teacherdao.selectTeacherList());
		
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request,response);		
	}
}
