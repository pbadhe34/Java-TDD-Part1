package com.server;

public class Client {
	
	private ControllerClass controller;
	

	public void setController(ControllerClass controller) {
		this.controller = controller;
	}


	public static void main(String[] args) {
		Client client = new Client();
		client.setController(getController());
		client.controller.doSearchAction();
		 
	}
	
	static ControllerClass getController()
	{
		if(true)
			return new ProcessController();
		else
			return new EntityController();
	}


}
