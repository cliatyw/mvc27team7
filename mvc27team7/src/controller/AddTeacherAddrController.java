/*[김도희]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/addTeacherAddr.kdh")
public class AddTeacherAddrController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		/*get방식으로 teacher_no의 값을 받아온다*/
		String teacher_no= request.getParameter("send_no");
		System.out.println(teacher_no+"<--teacher_no AddTeacherAddr");
		/*teacher_no의 값을 form으로 넘겨준다*/
		request.setAttribute("teacher_no", teacher_no);
		/*주소 입력폼으로 이동*/
		request.getRequestDispatcher("/WEB-INF/views/addTeacherAddr.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");	
		int teacher_no = Integer.parseInt(request.getParameter("teacher_no"));
		String address = request.getParameter("address");
		System.out.println(teacher_no+"<--teacher_no AddTeacherAddrController");
		System.out.println(address+"<--address AddTeacherAddrController");
		/*teacher_no와 address를 TeacherAddr에 세팅해준다*/
		TeacherAddr teacherAddr = new TeacherAddr();
		teacherAddr.setTeacherNo(teacher_no);
		teacherAddr.setAddress(address);
		/*DAO주소추가하는 메소드 실행*/
		TeacherAddrDao dao = new TeacherAddrDao();
		dao.insertTeacherAddr(teacherAddr);
		
	}
}
