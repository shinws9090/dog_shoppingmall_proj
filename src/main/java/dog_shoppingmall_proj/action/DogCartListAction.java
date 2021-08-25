package dog_shoppingmall_proj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shoppingmall_proj.dto.Cart;

public class DogCartListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		List<Cart> cartList = (List<Cart>) request.getSession().getAttribute("cartList");
		
		int totalMoney=0;
		for(Cart c : cartList) {
			totalMoney+=(c.getPrice()*c.getQty());
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		
		ActionForward forward = new ActionForward("dog_shopping/dogCartList.jsp");
		return forward;
	}

}
