package dog_shoppingmall_proj.action;

public class ActionForward {
	private String path;
	private boolean rediract;
	
	
	
	public ActionForward() {
	}

	
	public ActionForward(String path, boolean rediract) {
		super();
		this.path = path;
		this.rediract = rediract;
	}


	public ActionForward(String path) {
		super();
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRediract() {
		return rediract;
	}

	public void setRediract(boolean rediract) {
		this.rediract = rediract;
	}
	
	
	
}
