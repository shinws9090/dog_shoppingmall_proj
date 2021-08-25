package dog_shoppingmall_proj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dog_shoppingmall_proj.dto.Cart;
import dog_shoppingmall_proj.dto.Dog;
import dog_shoppingmall_proj.service.DogCartAddService;

public class DogCartRemoveAction implements Action {
	DogCartAddService service = new DogCartAddService();

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("?????????????????????????");
		HttpSession session = request.getSession();
		String[] remove = request.getParameterValues("remove");
		List<Cart> cartList = (List<Cart>) session.getAttribute("oldcartList");

		if (cartList == null) {
			cartList = (List<Cart>) session.getAttribute("cartList");
		}

		for (int i = 0; i < remove.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {
				if (cartList.get(j).getKind().equals(remove[i])) {
					cartList.remove(cartList.get(j));
				}
			}
		}
		
		session.setAttribute("cartList", cartList);
		session.setAttribute("oldcartList", cartList);

		ActionForward forward = new ActionForward("dogCartList.do", true);
		return forward;
	}

}
