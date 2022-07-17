import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
		// 识别login.html->form->input中的name属性，并获得相应的用户输入
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html;charset = UTF-8");

		User user = DBConnection.findUserByName(username);
		
		if (user == null || !user.getPassword().equals(password)) {
			response.sendRedirect("fail.html");
		}else {
			response.sendRedirect("success.html");
		}
	}
}