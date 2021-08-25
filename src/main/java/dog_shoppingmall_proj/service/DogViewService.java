package dog_shoppingmall_proj.service;

import java.sql.SQLException;

import dog_shoppingmall_proj.ds.JndiDS;
import dog_shoppingmall_proj.dto.Dog;

public class DogViewService extends DogService{
	
	public Dog getDogView(int id){
		Dog dog =null;
		try {
			
			con.setAutoCommit(false);
			
			dao.updateReadCount(id);
			dog = dao.selectDog(id);
			
			JndiDS.commit(con);
		}catch(SQLException e) {
			JndiDS.rollback(con);
			e.printStackTrace();
		}finally{
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dog;
	}
}
