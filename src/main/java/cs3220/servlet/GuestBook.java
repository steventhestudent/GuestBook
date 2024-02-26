package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public GuestBook() {
		super();
	}
	public void init() throws ServletException {
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Guest Book</title><style>td{border: 1px solid grey;}</style></head><body>");
		out.println("<h2>Guest Book</h2>");
		out.println("<table cellpadding=\"0\" cellspacing=\"0\" style=\"float: right;margin-right: 3em;\">");
		out.println("<tr><th>Name</th><th>Message</th><th>Edit | Delete</th></tr>");
		out.println("<tr><td>John</td><td>Hello!</td><td><a href=\"./EditEntry\">Edit</a> | <a href=\"DeleteEntry\">Delete</a></td></tr>");
		out.println("<tr><td>Jane</td><td>Hello Again!</td><td><a href=\"./EditEntry\">Edit</a> | <a href=\"DeleteEntry\">Delete</a></td></tr>");
		out.println("</table>");
		out.println("<div style=\"float: left;width: 100%;\"><a href=\"./AddComment\">Add Comment</a></div>");
		out.println("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
