package com.server;

public class Client {

	public static void main(String[] args) {
		Controller  controller = getController();		 
		controller.doSearchAction();
	}
	
	static Controller getController()
	{
		if(true)
			return new ProcessController();
		else
			return new EntityController();
	}

}
