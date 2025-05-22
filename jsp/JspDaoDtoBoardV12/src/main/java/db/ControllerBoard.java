package db;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
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
				nextPage = "/board/list";
				break;
			case"/write":
				Dto dto = new Dto(
						request.getParameter("title"),
						request.getParameter("id"),
						request.getParameter("text")
						);
				Dao dao2 = new Dao();
				dao2.write(dto);
				nextPage = "/board/list";
				break;
			case"/read":
				request.setAttribute("no", request.getParameter("no"));
				nextPage = "/read.jsp";
				break;
			case"/edit_insert":
				request.setAttribute("no", request.getParameter("no"));
				nextPage = "/edit.jsp";
				break;
			case"/edit_proc":
				Dto dto2 = new Dto(
						request.getParameter("title"),
						request.getParameter("text")
						);
				Dao dao3 = new Dao();
				dao3.edit(dto2,request.getParameter("no"));
				nextPage = "/list.jsp";
				break;
			case"/list":
				nextPage = "/list.jsp";
				break;
				
			}
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request,response);
		}
	}

}
