package com.server;

public class EntityController implements Controller {

	  /* (non-Javadoc)
	 * @see com.server.Controller#doAddAction()
	 */
	@Override
	public void doAddAction() {  System.out.println("EntityController.doAddAction()"); }
	  /* (non-Javadoc)
	 * @see com.server.Controller#doEditAction()
	 */
	@Override
	public void doEditAction() { System.out.println("EntityController.doEditAction()");  }
	  /* (non-Javadoc)
	 * @see com.server.Controller#doViewAction()
	 */
	@Override
	public void doViewAction() {  System.out.println("EntityController.doViewAction()"); }
	  /* (non-Javadoc)
	 * @see com.server.Controller#doDeleteAction()
	 */
	@Override
	public void doDeleteAction() { System.out.println("EntityController.doDeleteAction()");  }
	  /* (non-Javadoc)
	 * @see com.server.Controller#doSearchAction()
	 */
	@Override
	public void doSearchAction() { System.out.println("EntityController.doSearchAction()");  }
	 

}
