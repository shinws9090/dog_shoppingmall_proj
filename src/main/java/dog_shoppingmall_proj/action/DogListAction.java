package dog_shoppingmall_proj.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shoppingmall_proj.dto.Dog;
import dog_shoppingmall_proj.service.DogListService;

public class DogListAction implements Action {
	DogListService service = new DogListService();
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("DogListAction");
		List<String> todayImageList = new ArrayList<String>();
		
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null) {
			for(int i =0; i <cookieArray.length;i++) {
				if(cookieArray[i].getName().startsWith("today")) {
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		request.setAttribute("todayImageList", todayImageList);
		
		List<Dog> dogList = service.getDogList();
		request.setAttribute("dogList", dogList);
		
		ActionForward forward = new ActionForward("dog_shopping/dogList.jsp");
		return forward;
	}

}
