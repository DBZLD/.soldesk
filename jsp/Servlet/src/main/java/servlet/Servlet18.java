package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Servlet18")
public class Servlet18 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		if(id.equals("cat") && pw.equals("1234")) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(5);
			PrintWriter out = resp.getWriter();
	        out.println("<p><a href='q18.jsp'>Go to q18.jsp</a></p>");

		}
	}

}
