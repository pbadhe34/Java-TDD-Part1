package com.data.service;

public class UserServiceImpl implements UserService {

	@Override
	public boolean validateUser(String userName, String userPass) {
		if(userName.equals("ashok") && userPass.equals("morYa"))
		  return true;
		else
			 return false;
		}

}
