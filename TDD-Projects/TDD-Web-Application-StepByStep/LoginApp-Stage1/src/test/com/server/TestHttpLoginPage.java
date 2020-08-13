package test.com.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
 
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlBig;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Node;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLAnchorElement;

 

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

//Create a new local git repository and copy the files  and dirs manually to it. 
//-->git init
 
//THe test/com/server/TestHttpLoginPage.java and WebContent/userLogin.html files
//Switch to Git Repos dierctory created.
//Run the command as  'git add .' to add all from current dir
 //OR git add test/com/server/TestHttpLoginPage.java
//and  git add WebContent/userLogin.html

//View these files into the Git Repositories view

//Add a comment to the files added
//git commit -m "Initial Test login page and html page commit"

/*
 * 
 * Create new branch other than master
 * -->git branch origin
 * To list the Branches
 * -->git branch
 *  *master-->currently active branch
 *   origin
 * The current active branch is master,to switch the source tree to other branch 
 * -->git checkout origin
 * -->git branch 
 *      master 
 *   * origin-->currently active branch
 * The source tree now belongs to origin barnch
 * -->git status
 *  On branch origin
    nothing to commit, working directory clean
    
 */
/*  To add remote GIT repository for push,pull  [The 'html' is the name of remote repository configured]
	-->git remote add -t origin html http://admin@localhost:1100/gitblit/r/LoginApp-Repos.git	
	-->git remote -v
	*/
	
 /*
  *  To push to remote repository at dfifferent branch
  *  Sorce spec : refs/heads/origin
      Destination spec : refs/heads/html-code

     -->git push html  refs/heads/origin:refs/heads/html-code
     
      OR 
      
      -->git push http://admin@localhost:1100/gitblit/r/LoginApp-Repos.git  refs/heads/origin:refs/heads/html-code
  *
  */
 
  /*
  * To add and coommit to the remote repository select the git repository view
  * Right click and select the 'Remotes' folder in view and select create remote
  * OR right click the repose dir and select push branch master 
  * and configure the url and already selected branch master and specify userid and
  * password and select next to push. 
  * 
  * OR select -->remote push 
  * and in next screen view configure PUsh URL of repois as
  * http://admin@localhost:1100/gitblit/r/testLogin.git
  *  and in next screen select the source and desitnation references as refs/heads/master to sepcify the master branch
  *  and click on add 'All Branches Specific' button.
  *  Click next to specify user id and password of repois as admin and admin.  *    *   
  *   
  *   On the remote repos url you can see the comments added in Commit  and the files in tree section.
  */

//Test class is here
public class TestHttpLoginPage {
	
	private File htmlPage;
	private WebClient webClient;	
	private HtmlPage page;
	
	
	@Before
	public void setup()
	{
		htmlPage = new File("WebContent/userLogin.html");	 	 
	 	webClient = new WebClient();		
		 
	    try {
		 page = webClient.getPage("file:///"+htmlPage.getAbsolutePath());
		} catch (FailingHttpStatusCodeException e) {			 
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	   
	}
	
	@After
	public void tearDown()
	{
		 page.cleanUp();
		 webClient.close();
		 htmlPage = null;			 
	}
	@Test	 
	public void verifyLoginPageExists()  
	{
		boolean exists = htmlPage.exists();
		assertTrue(exists);		
	}
	
	@Test
	public void verifyLoginPageTitle() 
	{
		 String pageTitle = page.getTitleText();
		 assertEquals("Welcome to My App Login",pageTitle );
	}
		
	
	@Test
	public void verifyLoginPageMessage() 
	{
		DomElement elm = page.getElementById("divMessage");
		
		String text = elm.asText();
		assertEquals("Pl. submit your login credentilas here",text );
	}
	@Test
	public void verifyLoginPageForm() 
	{
		
		List forms = page.getForms();
		HtmlForm form = (HtmlForm)forms.get(0);
		assertNotNull(form); 

	}
	
	@Test
	public void verifyLoginPageFormByName() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		assertNotNull(form);

	}
	@Test
	public void verifyLoginFormID()
	{
		
		List forms = page.getForms();
		HtmlForm form = (HtmlForm)forms.get(0);
		String formID = form.getAttribute("id");
		assertEquals("frmLogin", formID);  

	}
	
	@Test
	public void checkLoginFormAction() 
	{
		
		List forms = page.getForms();
		HtmlForm form = (HtmlForm)forms.get(0);
		String action = form.getAttribute("action");
		assertEquals("loginServlet", action);  

	}
	@Test
	public void checkLoginFormMethod()
	{
		
		List forms = page.getForms();
		HtmlForm form = (HtmlForm)forms.get(0);
		String method = form.getAttribute("method");
		assertEquals("post", method);  

	}
	
	@Test
	public void verifyLoginPageFormElements() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		DomNodeList elmentList = form.getElementsByTagName("input");
		int num = elmentList.getLength();
		assertEquals(4, num);

	}
	
	@Test
	public void verifyLoginPageFormNameElement() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "name", "uName") ;		 
		int num = elements.size();
		assertEquals(1, num);

	}
	@Test
	public void verifyLoginPageFormNameSize() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "name", "uName") ;	
		HtmlElement el = (HtmlElement) elements.get(0);
		String value = el.getAttribute("size");
		assertEquals("20", value);

	}
	
	@Test
	public void verifyLoginPageFormPasswordElement() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "name", "uPass") ;		 
		int num = elements.size();
		assertEquals(1, num);
	}
	
	@Test
	public void verifyLoginPageFormPasswordType() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "name", "uPass") ;		 
		HtmlElement el = (HtmlElement) elements.get(0);
		String type = el.getAttribute("type");
		
		assertEquals("password", type);
	}
	 
	@Test
	public void verifyLoginPageFormLabels() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByTagName("label");		 
		int num = elements.size();
		assertEquals(2, num);
	}
	
	@Test
	public void verifyLoginPageFormUnameLabel() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByTagName("label");		 
		HtmlElement el = (HtmlElement) elements.get(0);
		String forField = el.getAttribute("for");
		assertEquals("userName", forField);
	}
	
	@Test
	public void verifyLoginPageFormPasswordLabel() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByTagName("label");		 
		HtmlElement el = (HtmlElement) elements.get(1);
		String forField = el.getAttribute("for");
		assertEquals("userPassword", forField);
	}

	@Test
	public void verifyLoginPageFormChildren() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");			 
		int numChildren =  form.getChildElementCount();		
		assertEquals(8, numChildren);
	}

	@Test
	public void verifyLoginPageFormLineBreak() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		DomNodeList elmentList = form.getElementsByTagName("br");
		int num = elmentList.getLength();
		assertEquals(2, num); 
		 

	}
	@Test
	public void verifyLoginPageFormLineBreakIndex() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		DomNodeList elmentList = form.getElementsByTagName("br");
		HtmlElement elm = (HtmlElement) elmentList.get(0);
		int index = elm.getIndex();
		assertEquals(5, index); 
	}
	
	@Test
	public void verifyLoginPageFormSecondLineBreakIndex() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		DomNodeList elmentList = form.getElementsByTagName("br");
		HtmlElement elm = (HtmlElement) elmentList.get(1);
		int index = elm.getIndex();
		assertEquals(10, index); 
	}
	
	@Test
	public void verifyLoginPageFormSubmitButton() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "type", "submit") ;		 
		int num = elements.size();
		assertEquals(1, num);		  
   }
	@Test
	public void verifyLoginPageFormSubmitButtonValue() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "type", "submit") ;
		HtmlElement elm = (HtmlElement) elements.get(0);
		String value = elm.getAttribute("value");
		assertEquals("UserLogin", value);		  
   }
	
	@Test
	public void verifyLoginPageFormSubmitButtonIDValue() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "type", "submit") ;
		HtmlElement elm = (HtmlElement) elements.get(0);
		String val = elm.getAttribute("id");
		assertEquals("userSubmit", val);		  
   }
	
	@Test
	public void verifyLoginPageFormClearButton() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "type", "reset") ;		 
		int num = elements.size();
		assertEquals(1, num);		  
   }
	@Test
	public void verifyLoginPageFormClearButtonValue() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "type", "reset") ;
		HtmlElement elm = (HtmlElement) elements.get(0);
		String value = elm.getAttribute("value");
		assertEquals("Clear", value);		  
   }
	public void verifyLoginPageFormClearButtonIdValue() 
	{
		
		HtmlForm form = page.getFormByName("loginForm");
		List elements = form.getElementsByAttribute("input", "type", "reset") ;
		HtmlElement elm = (HtmlElement) elements.get(0);
		String val = elm.getAttribute("id");
		assertEquals("clearValues", val);		  
   }
}
