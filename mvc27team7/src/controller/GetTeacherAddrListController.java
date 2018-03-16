/*[김도희]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/getTeacherAddrList.kdh")
public class GetTeacherAddrListController extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		/*teacher_no의 값을 받아온다.*/
		
		TeacherAddrDao dao = new TeacherAddrDao();
		/*teacher_addr_no,teacher_no,address의 값을  list에 담는다*/
		ArrayList<TeacherAddr> list = dao.selectTeacherAddrList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/getTeacherAddrList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
