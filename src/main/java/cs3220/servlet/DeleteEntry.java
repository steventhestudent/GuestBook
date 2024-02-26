package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;

@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DeleteEntry() {
		super();
	}
	public void init() throws ServletException {
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id_param = request.getParameter("id");
		if (id_param == null || id_param == "") {
			out.println("empty err");
			return;
		}
		int id = Integer.parseInt(id_param);
		GuestBookEntry[] entries = (GuestBookEntry[])getServletContext().getAttribute("entries");
		if (entries == null) {
			out.println("GuestBook not loaded err");
			return;
		}
		
		GuestBookEntry[] minusOne = new GuestBookEntry[entries.length - 1];
		int i = 0;for (GuestBookEntry cur : entries) {
			if (cur.id == id) continue;
			minusOne[i] = cur;
			i++;
		}
		getServletContext().setAttribute("entries", minusOne);
		response.sendRedirect("/GuestBook/GuestBook");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
