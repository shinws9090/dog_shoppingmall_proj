package dog_shoppingmall_proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	
	public static Connection getConnection() {
		Connection con = null;
		try {// 파일 내용 리소스 파일을 담는것
			
			String url = "jdbc:mysql://localhost:3306/dog_shoppingmall?useSSL=false";
			String id = "user_dog_shoppingmall";
			String passwd = "rootroot";
			
			con = DriverManager.getConnection(url,id,passwd);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

}
