package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getTeacherList.kdh")
public class GetTeacherController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request...
		//GuestDao
		//request�� �Ӽ��߰�
		//forward
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request,response);
		
	}

}