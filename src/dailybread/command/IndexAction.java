package dailybread.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dailybread.bean.BreadDBBean;
import dailybread.bean.BreadDataBean;

public class IndexAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		BreadDBBean db = BreadDBBean.getInstance();
		BreadDataBean bread = db.getNewBread();
		HttpSession session = request.getSession();
		
		session.setAttribute("newBread",bread);
		return "/newBread.jsp";
	}

}