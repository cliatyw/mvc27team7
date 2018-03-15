/*[김도희]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addTeacherAddr.kdh")
public class AddTeacherAddrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddTeacherAddrController() {
        super();
    }
    
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
		String teacher_no = request.getParameter("teacher_no");
		String address = request.getParameter("address");
		System.out.println(teacher_no+"<--teacher_no AddTeacherAddrController");
		System.out.println(address+"<--address AddTeacherAddrController");
	}
}
