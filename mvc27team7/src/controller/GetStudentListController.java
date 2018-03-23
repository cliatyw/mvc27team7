/*[최상욱]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.Student;
import model.StudentAddrDao;
import model.StudentDao;
@WebServlet("/getStudentList.csu")
public class GetStudentListController extends HttpServlet {
	private StudentAddrDao studentaddrdao = null;
	private StudentDao studentdao = null;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	studentaddrdao = new StudentAddrDao();
	studentdao = new StudentDao();
	
	int currentPage = 1;
	/*요청페이지에서 받을수도 있지만 10으로 통일*/
	int pagePerRow = 5;
	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int startRow = (currentPage-1)*pagePerRow;
	ArrayList<Student> list = studentdao.selectStudentList(startRow, pagePerRow);
	
	int totalRowCount = studentdao.countStudent();
	int lastPage = totalRowCount/pagePerRow;
	if(totalRowCount % pagePerRow !=0) {
		lastPage++;
	}
	for(Student student : list) {
		if(studentaddrdao.countStudentAddr(student.getStudentNo())>0) {
			student.setStudentPw("exist");
		}
	}
	request.setAttribute("lastPage", lastPage);
	request.setAttribute("currentPage", currentPage);
	request.setAttribute("list",list);
	request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
	}
}