package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentAddrDelete.csu")
public class StudentAddrDelete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameterValues("addrcheck"));
		String[] addrcheck = request.getParameterValues("addrcheck");
		for(int i=0; i<addrcheck.length; i++){
		      System.out.println(addrcheck[i]);
	    }
	}
}
