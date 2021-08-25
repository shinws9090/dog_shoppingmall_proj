package dog_shoppingmall_proj.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dog_shoppingmall_proj.JdbcUtil;
import dog_shoppingmall_proj.dao.impl.DogDAOimpl;
import dog_shoppingmall_proj.dto.Dog;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DogDAOTest {
	private static Connection con = JdbcUtil.getConnection();
	private static DogDAOimpl dao = DogDAOimpl.getInstance();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	

	@Test
	public void test01SelectDogList() {
		System.out.println("test01SelectDogList");
		List<Dog> list = dao.selectDogList();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectDog() {
		System.out.println("test02SelectDog");
		Dog dog = dao.selectDog(1);
		Assert.assertNotNull(dog);
		System.out.println(dog);
	}

	@Test
	public void test03InsertDog() {
		System.out.println("test03InsertDog");
		int res = dao.insertDog(new Dog("비숑",4000,"b.jpg","남극",1,20,"털많다"));
		Assert.assertEquals(1, res);
		System.out.println(res);
	}

	@Test
	public void test04UpdateReadCount() {
		System.out.println("test04UpdateReadCount");
		int res = dao.updateReadCount(1);
		System.out.println(res);
	}

}
