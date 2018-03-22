/*[김도희]*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherAddr;
import model.TeacherAddrDao;
import model.TeacherDao;

@WebServlet("/removeTeacher.kdh")
public class RemoveTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RemoveTeacherController() {
        super();       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*get방식으로 send_no의 값을 받아온다*/
		int teacher_no = Integer.parseInt(request.getParameter("send_no"));
		System.out.println(teacher_no+"<--teacher_no RemoveTeacher");
		/*DAO 삭제메서드 호출*/
		TeacherAddrDao addrdao = new TeacherAddrDao();
		TeacherAddr address = addrdao.selectTeacherAddr(teacher_no);
		System.out.println(address.getAddress()+"<--address");
		if(address.getAddress()!=null) {
			request.setAttribute("address", address.getAddress());
			request.getRequestDispatcher("/getTeacherList.kdh").forward(request,response);	
			/*response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("location.href='/mvc27team7/getTeacherList.kdh';");
			out.println("alert('주소값이 들어있어 삭제가 안됩니다.');");
			out.println("</script>");*/
		}else {
			TeacherDao dao = new TeacherDao();
			dao.deleteTeacher(teacher_no);
			response.sendRedirect(request.getContextPath()+"/getTeacherList.kdh");
		}
	}
}
