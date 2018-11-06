package org.mochito.mochito_core;

public class UserServiceImpl implements UserService {

	private final HashProvider hashProvider;

	public UserServiceImpl(HashProvider hashProvider) {
    	this.hashProvider = hashProvider;
	}


	public User createUser(String firstName, String password) {
		String hashedPassword = hashProvider.hash(password);
		return new User(firstName, hashedPassword);
	}
} 