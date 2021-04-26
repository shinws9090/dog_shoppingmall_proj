package dog_shoppingmall_proj.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shoppingmall_proj.action.Action;
import dog_shoppingmall_proj.action.ActionForward;

@WebServlet(urlPatterns = { "*.do" }, 
			loadOnStartup = 1, 
			initParams = {
					@WebInitParam(
				name = "configFile", 
				value = "/WEB-INF/commandAction.properties") 
					}) // 뭐여이게
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> actionMap = new HashMap<String, Action>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("configFile");
		try (InputStream is = config.getServletContext().getResourceAsStream(configFile)) {
			Properties props = new Properties();
			props.load(is);
			
			
			for (Entry<Object, Object> entry : props.entrySet()) {
				Class<?> cls = null;
				Action action = null;
				try {
					cls = Class.forName((String) entry.getValue());
					action = (Action) cls.newInstance();
				}catch(ClassNotFoundException e ){
//					action = new NullAction();
					e.printStackTrace();
				}
				actionMap.put((String) entry.getKey(), action);
			}
			

		} catch (IOException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String command = request.getServletPath();

		Action action = actionMap.get(command);
		ActionForward forward = action.execute(request, response);


		if (forward != null) {
			if (forward.isRediract()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
