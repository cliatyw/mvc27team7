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
		request.setCharacterEncoding("euc-kr");
		/*request에 teacher의 no,id값을 담은후 getTeacherList.jsp에 넘겨준다*/		
		int currentPage = 1;
		/*요청페이지에서 받을수도 있지만 10으로 통일*/
		int pagePerRow = 10;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			if(currentPage==0) {
				currentPage++;
			}
		}
		int startRow = (currentPage-1)*pagePerRow;	
		
		TeacherDao teacherdao = new TeacherDao();
		ArrayList<Teacher> teacherList = teacherdao.selectTeacherList(startRow,pagePerRow);
		
		int totalRowCount = teacherdao.countTeacher();
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount % pagePerRow !=0) {
			lastPage++;
		}
		ArrayList<Teacher> list = teacherdao.selectTeacherAddr();
		request.setAttribute("list", list);
		request.setAttribute("teacherList",teacherList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request,response);		
	}
}