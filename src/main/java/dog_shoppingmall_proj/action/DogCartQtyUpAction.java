package dog_shoppingmall_proj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shoppingmall_proj.dto.Cart;
import dog_shoppingmall_proj.dto.Dog;
import dog_shoppingmall_proj.service.DogCartAddService;

public class DogCartQtyUpAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String kind =request.getParameter("kind");
		List<Cart> cartList = (List<Cart>) request.getSession().getAttribute("cartList");
		
		for(Cart c : cartList) {
			if(c.getKind().equals(kind)) {
				c.setQty(c.getQty()+1);
			}
		}
		request.getSession().setAttribute("cartList",cartList);
		
		ActionForward forward = new ActionForward("dogCartList.do");
		return forward;
	}

}
