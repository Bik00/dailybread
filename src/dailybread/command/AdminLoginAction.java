package dailybread.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		String command = request.getParameter("command");
		if(command != null && command.equals("logout")) {
			session.invalidate();
			return "/adminLoginForm.jsp";
		}
		
		
		if(id == null || password == null)
			return "/adminLoginForm.jsp";
		if(id.equals("admin") && password.equals("admin")) {
			session.setAttribute("admin", "admin");
			return "/adminIndex.jsp";
		} else {
			session.removeAttribute("admin");
			request.setAttribute("error", "Not Match");
			return "/adminLoginForm.jsp";
		}
	}
}