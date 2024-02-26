package cs3220.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;

@WebServlet("/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public GuestBook() {
		super();
	}
	public void init() throws ServletException {
		GuestBookEntry[] x = {
			new GuestBookEntry("John", "Hello!"),
			new GuestBookEntry("Jane", "Hello Again!")
		};
		getServletContext().setAttribute("entries", x);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Guest Book</title><style>td{border: 1px solid grey;}</style></head><body>");
		out.println("<h2>Guest Book</h2>");
		out.println("<table cellpadding=\"0\" cellspacing=\"0\" style=\"float: right;margin-right: 3em;\">");
		out.println("<tr><th>Name</th><th>Message</th><th>Edit | Delete</th></tr>");
		GuestBookEntry[] entries = (GuestBookEntry[])getServletContext().getAttribute("entries");
		for (GuestBookEntry e : entries) {
			out.println("<tr><td>" + e.name + "</td><td>" + e.msg + "</td><td><a href=\"./EditEntry?id=" + e.id + "\">Edit</a> | <a href=\"DeleteEntry?id=" + e.id + "\">Delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("<div style=\"float: left;width: 100%;\"><a href=\"./AddComment\">Add Comment</a></div>");
		out.println("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
