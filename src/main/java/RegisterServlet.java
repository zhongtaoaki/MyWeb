import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
		// login.html -> <form> -> <input> の name 属性で指定されたデータを獲得
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html;charset = UTF-8");

		if (UserService.createUser(new User(username, password))) {
			response.sendRedirect("/MyWeb/login.html");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html");
			out.println("<html><body><p>");
			out.println("用户名已存在");
			out.println("</p></body></html>");
		}

	}
}