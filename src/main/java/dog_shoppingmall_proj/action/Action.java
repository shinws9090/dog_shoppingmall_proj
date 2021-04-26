package dog_shoppingmall_proj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shoppingmall_proj.dto.ActionForward;

public interface Action {

	ActionForward execute(HttpServletRequest request, HttpServletResponse response);

}
