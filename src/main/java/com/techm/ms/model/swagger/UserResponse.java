package com.techm.ms.model.swagger;

import com.techm.ms.model.User;
import com.techm.ms.model.representation.Resource;

public class UserResponse extends Resource<User> {

	public UserResponse(User content) {
		super(content);
	}

    /**
     * This method gets the content of the Account Response 
     * @return content of the user Response
     * 
     */
	@Override
	public User getContent() {
		return super.getContent();
	}

	
}
