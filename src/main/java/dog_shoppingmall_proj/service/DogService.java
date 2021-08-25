package dog_shoppingmall_proj.service;

import java.sql.Connection;

import dog_shoppingmall_proj.dao.impl.DogDAOimpl;
import dog_shoppingmall_proj.ds.JndiDS;

public class DogService {
	protected DogDAOimpl dao = DogDAOimpl.getInstance();

	protected Connection con = JndiDS.getConnection();

	public DogService() {
		dao.setCon(con);
	}
}
