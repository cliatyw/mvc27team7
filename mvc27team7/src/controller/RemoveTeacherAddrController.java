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

@WebServlet("/removeTeacherAddr.kdh")
public class RemoveTeacherAddrController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*체크된 값들을 가져온다*/
		String[] del_check = request.getParameterValues("del_check");
		int del_check_no = 0;	
		/*teacher_no의 값을 가져온다*/
		String teacher_no = request.getParameter("teacher_no");
		for(int i=0; i<del_check.length; i++) {
			/*int형변환*/
			del_check_no =Integer.parseInt(del_check[i]);
			System.out.println(del_check_no+"<--del_check_no doGet(removeTeacherAddr.kdh)");
			/*주소삭제메소드 실행*/
			TeacherAddrDao dao = new TeacherAddrDao();
			dao.deleteTeacherAddr(del_check_no);
		}		
		/*리스트로 redirect*/
		response.sendRedirect(request.getContextPath()+"/getTeacherAddrList.kdh?teacher_no="+teacher_no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
