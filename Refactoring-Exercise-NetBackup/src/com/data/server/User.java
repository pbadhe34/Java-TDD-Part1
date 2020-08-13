package com.data.server;

public class User {
    boolean result=true;
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public void login(String id, String pass) throws Exception {
		System.out.println("User.login()");
		if(id.isEmpty()|pass.isEmpty())
		{
			System.out.println("Throwing the error!");
			throw new Exception("Either id or password is empry..");
		}
		if((id.equals("DON"))&(pass.equals("Mumkin")))
			result = true;
		else
			result = false;		
	}

}
