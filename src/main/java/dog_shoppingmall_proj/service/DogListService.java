package dog_shoppingmall_proj.service;

import java.util.List;

import dog_shoppingmall_proj.dto.Dog;

public class DogListService extends DogService{
	
	public List<Dog> getDogList(){
		return dao.selectDogList();
	}
	
}
