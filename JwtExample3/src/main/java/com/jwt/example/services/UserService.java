package com.jwt.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.example.models.User;

@Service
public class UserService {
	
	List<User>store = new ArrayList<>();

	public UserService() {
		store.add(new User(UUID.randomUUID().toString(),"Tushar Gawande", "tgawande04@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Rameshwar Gawande", "rgawande2001@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Mahesh Kadam", "kadammahesh203@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Rohit Zade", "Rohit07@gmail.com"));
		
	}
	
	public List<User> getUsers(){
		return this.store;
	}
	
	

}
