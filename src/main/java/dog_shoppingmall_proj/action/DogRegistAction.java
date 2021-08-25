package dog_shoppingmall_proj.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dog_shoppingmall_proj.dto.Dog;
import dog_shoppingmall_proj.service.DogRegistService;

public class DogRegistAction implements Action {
	DogRegistService service = new DogRegistService();

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		String path = request.getServletContext().getRealPath("/images");
		System.out.println(path);
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 5 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());

			String kind = multi.getParameter("kind");
			int price = Integer.parseInt(multi.getParameter("price"));
			String image = multi.getFilesystemName("image");
			String country = multi.getParameter("country");
			int height = Integer.parseInt(multi.getParameter("height"));
			int weight = Integer.parseInt(multi.getParameter("weight"));
			String content = multi.getParameter("content");
			
			Dog dog = new Dog(kind, price, image, country, height, weight, content);
			boolean isInsert = service.registDog(dog);
			if(isInsert) {
				forward = new ActionForward("doglist.do");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록실패')");
				out.println("history.back();");
				out.println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return forward;
	}

}
