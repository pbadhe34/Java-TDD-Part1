package com.server;

public abstract class ControllerClass {

	public ControllerClass() {
		super();
	}

	public abstract void doSearchAction();

	public void doAddAction() {  System.out.println("EntityController.doAddAction()"); }

	public void doEditAction() { System.out.println("EntityController.doEditAction()");  }

	public void doViewAction() {  System.out.println("EntityController.doViewAction()"); }

	public void doDeleteAction() { System.out.println("EntityController.doDeleteAction()");  }

}