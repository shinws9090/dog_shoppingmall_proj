package dog_shoppingmall_proj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shoppingmall_proj.service.DogListService;

public class DogRegistFormAction implements Action {
	DogListService service = new DogListService();
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward("dog_shopping/dogRegistForm.jsp");
		return forward;
	}

}
