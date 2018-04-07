package com.techm.ms.service;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.techm.ms.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

private static final AtomicLong counter = new AtomicLong();
	
	private static HashMap<Long, User> map = new HashMap<>();
	
	
	static {
		map= populateDummyusers();
	}

	/**
	 * find user by id
	 */
	public User findById(long id) {
		for(Long k : map.keySet()){
			if(k==id){
			User user = map.get(k);
			return user;
			}
		}
		return null;
	}
	
	/**
	 * find user by name.
	 */
	public User findByName(String name) {
		for(Long k : map.keySet()){
			User user = map.get(k);
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	/**
	 * create a new user if the user with name doesnt exist.
	 */
	
	public User saveUser(User user) {
		if(findByName(user.getName())==null){
		map.put(counter.incrementAndGet(), user);
		return user;
		}
		return null;
	}

	/**
	 * check if the user exists
	 */
	
	public boolean isUserExist(User user) {
		
		return findByName(user.getName())!=null;
	}
	
	
	/**
	 * create few users to start off.
	 * @return
	 */
	private static HashMap<Long,User> populateDummyusers(){
		map.put(counter.incrementAndGet(), new User(counter.incrementAndGet(),"User1",1,1 ));
		map.put(counter.incrementAndGet(), new User(counter.incrementAndGet(),"User2",2,3 ));
		map.put(counter.incrementAndGet(), new User(counter.incrementAndGet(),"User3",2,3 ));
		
		return map;
	}


}
