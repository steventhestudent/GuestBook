package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		out.println("<html><head><title>Edit Comment</title></head><body>");
		out.println("<h2>Edit Comment</h2><form action=\"./EditEntry\" method=\"GET\">");
		out.println("<label>Name: </label><input type=\"text\" />");
		out.println("<div style=\"width: 100%;\"><textarea rows=\"5\" style=\"width: 30em;resize: none;\"></textarea></div>");
		out.println("<button>Update Comment</button>");
		out.println("</form></body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
