package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStudent.csu")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//�Է� �� ��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	//�Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.request ó��
		//2.��dao ȣ��
		//3.�ٸ� ��Ʈ�ѷ� ȣ��
		
	}

}