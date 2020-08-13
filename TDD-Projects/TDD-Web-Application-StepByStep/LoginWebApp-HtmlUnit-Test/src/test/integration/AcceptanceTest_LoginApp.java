package test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import com.gargoylesoftware.htmlunit.BrowserVersion;
 
public class AcceptanceTest_LoginApp {
	
	private HtmlPage page;
	private WebClient webClient;
	
	@Before
	public void setup()
	{
		Properties props = new Properties();
		InputStream input;
		try {
			input = new FileInputStream("build.properties");
			props.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = props.getProperty("app-url")+"/"+props.getProperty("project-name");
		 
		/*System.out.println(props.getProperty("project-name"));
		System.out.println(props.getProperty("app-url")+"/"+props.getProperty("project-name"));
		System.out.println(props.getProperty("tomcat-manager-url"));
		*/
		
		//webClient = new WebClient();

webClient  = new WebClient(BrowserVersion.CHROME);  	
 	    
		try {
			page = webClient.getPage(url);
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@After
	public void tearDown()
	{
		 //page.cleanUp();
		 //webClient.close();
		 //page = null;		 
		 
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
	public void checkLoginSuccessAction() 
	{
	Page nextPage = null;
	HtmlForm form = page.getFormByName("loginForm");
	List elements = form.getElementsByTagName("input") ;		 
	HtmlElement uname = (HtmlElement) elements.get(0);
	uname.setAttribute("value", "ashok");
	//uname.setTextContent("ashok");
	HtmlElement upass = (HtmlElement) elements.get(1);
	//upass.setTextContent("morYa");
	upass.setAttribute("value", "morYa");
	HtmlElement submitBtn = (HtmlElement) elements.get(2);
	try {
		nextPage  = submitBtn.click();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 String textResponse = nextPage.getWebResponse().getContentAsString();
	 
	 assertEquals("Login successfull...", textResponse);
	}
	
	@Test
	public void checkLoginError() 
	{
	Page nextPage = null;
	HtmlForm form = page.getFormByName("loginForm");
	List elements = form.getElementsByTagName("input") ;		 
	HtmlElement uname = (HtmlElement) elements.get(0);
	uname.setAttribute("value", "asas");
	//uname.setTextContent("ashok");
	HtmlElement upass = (HtmlElement) elements.get(1);
	//upass.setTextContent("morYa");
	upass.setAttribute("value", "cscsa");
	HtmlElement submitBtn = (HtmlElement) elements.get(2);
	try {
		nextPage  = submitBtn.click();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 String textResponse = nextPage.getWebResponse().getContentAsString();
	 
	 assertEquals("Login Error...", textResponse);
	}
		 

}
