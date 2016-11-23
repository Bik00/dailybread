package dailybread.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	public String requestPro(
			HttpServletRequest reqeust, HttpServletResponse response)
	throws Throwable;
}
