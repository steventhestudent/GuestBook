package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AddComment() {
		super();
	}
	public void init() throws ServletException {
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// do these params exist? form was submitted.  update entry
		String name_param = request.getParameter("name");
		String msg_param = request.getParameter("msg");
		if (name_param != null && msg_param != null) {
			
			GuestBookEntry[] entries = (GuestBookEntry[])getServletContext().getAttribute("entries");
			if (entries == null) {
				out.println("GuestBook not loaded err");
				return;
			}
			int newLen = entries.length + 1;
			GuestBookEntry[] plusOne = new GuestBookEntry[newLen];
			System.arraycopy(entries, 0, plusOne, 0, entries.length);
			plusOne[newLen - 1] = new GuestBookEntry(name_param, msg_param);
			getServletContext().setAttribute("entries", plusOne);
			response.sendRedirect("/GuestBook/GuestBook");
		}
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<h2>Add Comment</h2><form action=\"./AddComment\" method=\"GET\">");
		out.println("<label>Name: </label><input name=\"name\" type=\"text\" />");
		out.println("<div style=\"width: 100%;\"><textarea name=\"msg\" rows=\"5\" style=\"width: 30em;resize: none;\"></textarea></div>");
		out.println("<button>Add Comment</button>");
		out.println("</form></body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
