package dailybread.command;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dailybread.bean.BreadDBBean;
import dailybread.bean.BreadDataBean;

public class NewBreadAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8"); //한글 인코딩
		
		String filename="";
		String realFolder="";
		String saveFolder="/upload";
		String encType="utf-8";
		int maxSize = 5*1024*1024;
		

		
		ServletContext = context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		try {
			imageUp = new MultipartRequest(request,realFolder,maxSize,encType, new DefaultFileRenamePolicy());
			
			Enumeration<?> files = imageUp.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				
				filename=imageUp.getFilesystemName(name);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		BreadDataBean = bread = new BreadDataBean();
		bread.setBreadName(imageUp.getParameter("breadName"));
		bread.setImageUrl(filename);
		bread.setIngredient(imageUp.getParameter("ingredient"));
		bread.setCreatedCount(Integer.parseInt(imageUp.getParameter("createdCount")));
		bread.setPrice(Integer.parseInt(imageUp.getParameter("price")));
		
		BreadDBBean db = BreadDBBean.getInstance();
		int result = db.addNewBread(bread);
		
		if(result == 0)
			request.setAttribute("result", "Succeed");
		else
			request.setAttribute("result", "Error!");
		return "/adminIndex.jsp";
	}

}