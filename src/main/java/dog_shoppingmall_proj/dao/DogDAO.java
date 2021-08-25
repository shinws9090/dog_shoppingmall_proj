package dog_shoppingmall_proj.dao;

import java.util.List;

import dog_shoppingmall_proj.dto.Dog;

public interface DogDAO {
	List<Dog> selectDogList();
	
	Dog selectDog(int id);
	
	int insertDog(Dog dog);

	int updateReadCount(int id);
	
	
}
