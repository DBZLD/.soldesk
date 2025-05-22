package db;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/java/*")
public class ControllerBoard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		String nextPage = "";
		if(action != null) {
			switch(action) {
			case"/del":
				System.out.println("del");
				String no=request.getParameter("no");
				Dao dao = new Dao();
				dao.del(no);
				nextPage = "/java/list";
				break;
			case"/write":
				Dto dto = new Dto(
						request.getParameter("title"),
						request.getParameter("id"),
						request.getParameter("text")
						);
				Dao dao2 = new Dao();
				dao2.write(dto);
				nextPage = "/java/list";
				break;
			case"/list":
				nextPage="/list.jsp";
				break;
				default:
					System.out.println("defalut controller");
					break;
			}
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request,response);
		}
	}

}
