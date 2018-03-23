/*[김기성]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeAddrDao;
import model.EmployeeDao;

@WebServlet("/getEmployeeList.kks")
public class GetEmployeeListController extends HttpServlet {
	private EmployeeDao employeeDao = null;
	private EmployeeAddrDao employeeAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*
		 * Dao 호출
		 * request에 속성 추가
		 * v 로 포워드
		 */ 
		employeeDao = new EmployeeDao();
		employeeAddrDao = new EmployeeAddrDao();
		
		int currentPage = 1;
		int pagePerRow = 10;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		//startRow를 구하여 top쿼리 실행 후 list에 대입한다.
		int startRow = (currentPage-1) * pagePerRow;
		ArrayList<Employee> list = employeeDao.selectEmployeeList(startRow, pagePerRow);
		//lastPage 구하기 위한 방법
		int lastPage = employeeDao.countEmployee()/pagePerRow;
		if(employeeDao.countEmployee()%pagePerRow != 0) {
			lastPage++;
		}
		//주소를 가지고 있으면 pw를 exist로 셋팅
		for(Employee employee : list) {
			if(employeeAddrDao.countEmployeeAddr(employee.getEmployeeNo())>0) {
				employee.setEmployeePw("exist");
			}
		}
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		//employee list를 리턴받는 매서드를 사용한후 request에 속성을 추가한다.
		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/views/getEmployeeList.jsp").forward(request, response);
	}
}
