/*[김도희]*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/addTeacherAddr.kdh")
public class AddTeacherAddrController extends HttpServlet {
	/*send_no의 값을 받아와 forward로 주소입력폼으로이동*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		/*teacher_no값 받아온후 주소개수구하기*/
		int teacher_no = Integer.parseInt(request.getParameter("send_no"));
		TeacherAddrDao dao = new TeacherAddrDao();
		int count = dao.countTeacherAddr(teacher_no);
		System.out.println(count+"<--count doGet(addTeacherAddr.kdh)");
		/*주소개수를 주소추가화면으로 보내기*/
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/views/addTeacherAddr.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");	
		/*count,teacher_no,address의 값 받아오기*/
		int count = Integer.parseInt(request.getParameter("count"));
		System.out.println(count+"<--count doPost(/addTeacherAddr.kdh) ");
		int teacher_no = Integer.parseInt(request.getParameter("teacher_no"));
		System.out.println(teacher_no+"<--count doPost(/addTeacherAddr.kdh) ");
		String address = request.getParameter("address");
		System.out.println(address+"<--address AddTeacherAddrController");
		/*if문으로 count가 5이상이면 주소리스트화면으로 이동,아니면 주소추가*/
		if(count>=5) {
			/*redirect로 주소리스트화면으로이동*/
	   		response.sendRedirect(request.getContextPath()+"/getTeacherAddrList.kdh?teacher_no="+teacher_no);
		}else {
			/*teacher_no와 address를 TeacherAddr에 세팅해준다*/
			TeacherAddr teacherAddr = new TeacherAddr();
			teacherAddr.setTeacherNo(teacher_no);
			teacherAddr.setAddress(address);
			/*DAO주소추가하는 메소드 실행*/
			TeacherAddrDao dao = new TeacherAddrDao();
			dao.insertTeacherAddr(teacherAddr);
			/*redirect로 주소리스트화면으로이동*/
			response.sendRedirect(request.getContextPath()+"/getTeacherAddrList.kdh?teacher_no="+teacher_no);
		}		
	}
}
