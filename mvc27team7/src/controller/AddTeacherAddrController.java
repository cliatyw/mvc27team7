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
		request.getRequestDispatcher("/WEB-INF/views/addTeacherAddr.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");	
		int teacher_no = Integer.parseInt(request.getParameter("teacher_no"));
		String address = request.getParameter("address");
		System.out.println(teacher_no+"<--teacher_no AddTeacherAddrController");
		System.out.println(address+"<--address AddTeacherAddrController");
		/*DAO주소개수*/
		TeacherAddrDao dao = new TeacherAddrDao();
		int count = dao.countTeacherAddr(teacher_no);
		System.out.println(count+"<--count");
		/*if문으로 count가 5이상이면 주소리스트화면으로 이동,아니면 주소추가*/
		if(count>=5) {
			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('주소가5개이상입니다');");
	   		out.println("location.href='/mvc27team7/getTeacherAddrList.kdh';");
	   		out.println("</script>");
		}else {
			/*teacher_no와 address를 TeacherAddr에 세팅해준다*/
			TeacherAddr teacherAddr = new TeacherAddr();
			teacherAddr.setTeacherNo(teacher_no);
			teacherAddr.setAddress(address);
			/*DAO주소추가하는 메소드 실행*/
			dao.insertTeacherAddr(teacherAddr);
		}		
	}
}
