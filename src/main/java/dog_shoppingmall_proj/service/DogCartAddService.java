package dog_shoppingmall_proj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dog_shoppingmall_proj.dto.Cart;
import dog_shoppingmall_proj.dto.Dog;

public class DogCartAddService extends DogService{
	
	public Dog getCartDog(int id){
		return dao.selectDog(id);
	}

	public void addCart(HttpServletRequest request, Dog cartDog) {
		List<Cart> cartList = (List<Cart>) request.getSession().getAttribute("cartList");
		
		if(cartList==null) {
			cartList= new ArrayList<Cart>();
			request.getSession().setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		for(Cart c : cartList) {
			if(cartDog.getKind().equals(c.getKind())) {
				isNewCart = false;
				c.setQty(c.getQty()+1);
				break;
			}
		}
		
		if(isNewCart) {
			Cart cart = new Cart(cartDog.getImage(), cartDog.getKind(), cartDog.getPrice(), 1);
			cartList.add(cart);
		}
	}
	
}
