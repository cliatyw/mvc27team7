/*[�赵��]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addTeacher.kdh")
public class TeacherController extends HttpServlet {
	//teacher �Է� ����û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request,response);
	}
	//guest �Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. requestó��
		//2. ��(DAO) ȣ��
		//3. redirect
	}

}
