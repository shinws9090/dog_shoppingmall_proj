package dog_shoppingmall_proj.service;

import dog_shoppingmall_proj.dto.Dog;

public class DogRegistService extends DogService{
	
	public boolean registDog(Dog dog){
		return dao.insertDog(dog)==1?true:false;
	}
	
}
