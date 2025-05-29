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
	ServiceBoard service;
	String nextPage;
	
	public void init() throws ServletException {
		service = new ServiceBoard();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if(action != null) {
			switch(action) {
			case"/del":
				service.deleteBoard(request.getParameter("no"));
				nextPage = "/board/list";
				break;
			case"/write":
				Dto dto = new Dto(
						request.getParameter("title"),
						request.getParameter("id"),
						request.getParameter("text")
						);
				service.writeBoard(dto);
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
				service.editBoard(dto2, request.getParameter("no"));
				nextPage = "/list.jsp";
				break;
			case"/list":
				request.setAttribute("blp", service.listBoard(request.getParameter("currentPage")));
				nextPage = "/list.jsp";
				break;
			}
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request,response);
		}
	}

}
