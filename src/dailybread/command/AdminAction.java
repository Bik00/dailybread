package dailybread.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String admin = (String)session.getAttribute("admin");
		
		if(admin != null)
			return "/adminIndex.jsp";
		else
			return "/adminLoginForm.jsp";
	}

}
