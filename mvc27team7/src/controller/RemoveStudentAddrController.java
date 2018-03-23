package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/removeStudentAddr.csu")
public class RemoveStudentAddrController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] student_addr_no = request.getParameterValues("getStudentAddrNo");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		System.out.println(request.getParameter("studentNo"));
		int checkListNo = 0;

		StudentAddrDao dao = new StudentAddrDao();
		for(int i=0; i<student_addr_no.length; i++){
			checkListNo = Integer.parseInt(student_addr_no[i]);
			dao.deleteStudent(checkListNo);
			
	    }
		response.sendRedirect(request.getContextPath()+"/getStudentListAddr.csu?studentNo="+studentNo);
	}
}
