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
		
		TeacherDao dao = new TeacherDao();
		dao.deleteTeacher(teacher_no);
		response.sendRedirect(request.getContextPath()+"/getTeacherList.kdh");
		}
	}

