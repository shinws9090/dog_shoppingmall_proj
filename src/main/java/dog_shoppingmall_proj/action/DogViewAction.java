package dog_shoppingmall_proj.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shoppingmall_proj.dto.Dog;
import dog_shoppingmall_proj.service.DogViewService;

public class DogViewAction implements Action {
	DogViewService service = new DogViewService();
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("DogViewAction");
		
		int id =Integer.parseInt(request.getParameter("id"));
		Dog dog = service.getDogView(id);
		
		request.setAttribute("dog", dog);
		Cookie todayImageCookie = new Cookie("today"+id, dog.getImage());
		todayImageCookie.setMaxAge(60*60*24);
		response.addCookie(todayImageCookie);
		
		ActionForward forward = new ActionForward("dog_shopping/dogView.jsp");
		return forward;
	}

}
