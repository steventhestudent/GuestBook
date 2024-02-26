package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;

@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public EditEntry() {
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
		GuestBookEntry tar = entries[id];
		if (tar == null) {
			out.println("DNE err");
			return;
		}
		
		// do these params exist? form was submitted.  update entry
		String name_param = request.getParameter("name");
		String msg_param = request.getParameter("msg");
		if (name_param != null && msg_param != null) {
			tar.name = name_param;
			tar.msg = msg_param;
			response.sendRedirect("/GuestBook/GuestBook");
		}
		
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<h2>Edit Comment</h2><form action=\"./EditEntry\" method=\"GET\">");
		out.println("<label>Name: </label><input name=\"name\" type=\"text\" value=\"" + tar.name + "\" />");
		out.println("<div style=\"width: 100%;\"><textarea name=\"msg\" rows=\"5\" style=\"width: 30em;resize: none;\">" + tar.msg + "</textarea></div>");
		out.println("<button>Update Comment</button>");
		out.println("<input type=\"hidden\" name=\"id\" value=\"" + tar.id + "\" />");
		out.println("</form></body></html>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
