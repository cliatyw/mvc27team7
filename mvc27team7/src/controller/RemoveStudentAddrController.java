package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddrDao;

@WebServlet("/studentAddrDelete.csu")
public class RemoveStudentAddrController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameterValues("addrcheck"));
		String studentNo = request.getParameter("studentNo");
		String[] student_addr_no = request.getParameterValues("addrcheck");
		for(int i=0; i<student_addr_no.length; i++){
		      System.out.println(student_addr_no[i]);
				StudentAddrDao dao = new StudentAddrDao();
				dao.deleteStudent(student_addr_no[i]);
	    }
		response.sendRedirect(request.getContextPath()+"/getStudentListAddr.csu?studentNo=" + studentNo);
	}
}
