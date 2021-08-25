package dog_shoppingmall_proj.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dog_shoppingmall_proj.dto.Cart;
import dog_shoppingmall_proj.service.DogCartAddService;

public class DogCartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DogCartSearchAction");
		HttpSession session = request.getSession();

		int startMoney = Integer.parseInt(request.getParameter("startMoney"));
		int endMoney = Integer.parseInt(request.getParameter("endMoney"));

		List<Cart> oldcartList = (List<Cart>) session.getAttribute("oldcartList");
		
		if (oldcartList == null) {
			oldcartList = (List<Cart>) session.getAttribute("cartList");
			session.setAttribute("oldcartList", oldcartList);
		}
		List<Cart> cartList = new ArrayList<Cart>();
		for (Cart c : oldcartList) {
			if (startMoney <= c.getPrice() && c.getPrice() <= endMoney) {
				cartList.add(c);
			}
		}

		session.setAttribute("cartList", cartList);

		ActionForward forward = new ActionForward("dogCartList.do");
		return forward;
	}

}
