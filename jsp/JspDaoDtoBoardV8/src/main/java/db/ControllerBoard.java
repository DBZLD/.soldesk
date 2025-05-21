package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/db/*")
public class ControllerBoard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		String nextPage = "";
		if(action == null) {
			switch(action) {
			case"/del":
				String no=request.getParameter("no");
				Dao dao = new Dao();
				dao.del(no);
				nextPage = "/db/list";
				break;
			}
		}
	}

}
