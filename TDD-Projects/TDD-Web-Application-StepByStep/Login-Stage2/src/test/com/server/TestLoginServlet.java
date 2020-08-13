package test.com.server;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.data.service.UserService;
import com.server.LoginServlet;
 
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.test.util.ReflectionTestUtils;

////Create a new local git repository test-login-stage2
//-->git init
//and copy the test and com dir from current project to it manually   
//THe fiiles copied are test/com/server/TestLoginServlet.java,TestUserService.java and com/server/LoginSerevclet.java and  com/data/service *.java files
//Open the terminal and Switch to New Git Repos dierctory created.
 
//Run folowing commands
//git add test/com/server/TestLoginServlet.java
//git add test/com/server/TestUserService.java
//git add com/server/LoginServlet.java
//git add com/data/service/UserService.java   //Ignore warning related to CRLF characters
//git add com/data/service/UserServiceImpl.java


//View these files into the Git Repositories view

//Add a comment to the files added
//git commit -m "The  login service classes to commit"

//To update existing file and then commit
//git add <path/filename>
//git commit -m <message>

//To get the recent status with commit or files added for staging 
//git status

/*
 * Create new branch service
 * -->git branch service
 * List the brnaches
 * -->git branch
 *   * master
 *     service
 *   To make the service branch active
 *   -->git checkout service
 *   Switched to branch 'service'
 *   
 *   List the brnaches
 * -->git branch
 *     master
 *    * service  -->The current active branch
 *    
 */

/*To list the remotes configred with local current repos
 * git remote -v
 * 
 * 
 * To add a new remote, use the git remote add command on the terminal, 
 * in the directory your repository is stored at.
 * A remote name, for example, origin and 
   A remote URL, for example, https://github.com/user/repo.git
 * 
 * -->git remote add remote-service http://admin@localhost:1100/gitblit/r/LoginApp-Repos.git
 * 
 * -->git remote -v
 * 
 * To push the current service branch to remote-service with NEW branch as service-code
 * /*
  *  To push to remote repository at different branch
  *  Source spec : refs/heads/service
      Destination spec : refs/heads/service-code

     -->git push remote-service  refs/heads/service:refs/heads/service-code
     
      OR 
      
      -->git push http://admin@localhost:1100/gitblit/r/LoginApp-Repos.git refs/heads/service:refs/heads/service-code
  *
  *

 * 
 */


/*
The git remote set-url command takes two arguments:

A remote name, for example, origin
A remote URL, for example, https://github.com/user/repo.git
 * To configure remote repos url
 * The 'git remote set-url' command changes an existing remote repository URL.
 * The git remote set-url command takes two arguments:

An existing remote name. For example, origin or upstream are two common choices.
To chnage with new URL for the remote. For example:

 git remote set-url master http://admin@localhost:1100/gitblit/r/testLogin.git
 
 After this the next time you git fetch, git pull, or git push to the remote repository, 
 you'll be asked for your GitHub username and password.

 */
		

/*
* To add and coommit to the remote repository select the git repository view
* Right click and select the 'Remotes' folder in view and select create remote
* OR right click the repose dir and select push branch master 
* and configure the url and already selected branch master and specify userid and
* password and select next to push. 
* 
* Use git push to push commits made on your local branch to a remote repository.
*  The git push command takes two arguments: A remote name, for example, origin. A branch name, for example, master.
-->git push origin master
*  
* To push to remote repository which is alreday existing brnach error : fast-forwradb update failed.
* Usually this is caused by another user pushing to the same branch. You can remedy this by 
* fetching and merging the remote branch, or using pull to perform both at once.
*  
* It means there have been other commits pushed to the remote repository that differ 
* from your commits.  
* 
* The git pull is shorthand for git fetch followed by git merge FETCH_HEAD . 
* More precisely, git pull runs git fetch with the given parameters and calls git merge to merge the
*  retrieved branch heads into the current branch. ... <repository> should be the name of a remote repository 
*  as passed to git-fetch[1].

The git pull internally uses( git fetch + git merge )
The git pull and clone are  basically the same, except clone will setup additional remote tracking branches,
 not just master.
 
 git fetch --all sets up additional remote tracking branches
 
 Git Clone : Clones a repository into a newly created directory, creates remote-tracking branches for each branch 
 in the cloned repository (visible using git branch -r), and creates and checks out an initial branch that is 
 forked from the cloned repository's currently active branch.
 
git pull master master --allow-unrelated-histories
before you push

you might want to use force with push operation in this case

git push origin master --force

To pull and update and push new changes
git pull master master
git push master master

*  
* Undo a commit and redo
$ git commit -m "Something terribly misguided"              (1)
$ git reset HEAD~                                           (2)
<< edit files as necessary >>                               (3)
$ git add ...                                               (4)
$ git commit -c ORIG_HEAD   

* http://admin@localhost:1100/gitblit/r/testLogin.git
* 
*       *   
*   
*   On the remote repos url you can see the comments added in Commit  and the files in tree section.
*   
*   The command  'git status'  shows  the files  changed since the last push
*   
* Very simple. Just follow these procedure:
1. git status
2. git add {File_Name} //the file name you haven been changed
3. git status
4. git commit -m '{your_message}'
5. git push origin master
*/


 
public class TestLoginServlet {  
	 
	 @Mock
	 private HttpServletRequest request;
	 @Mock
	 private HttpServletResponse response;
	 
	 @Mock
	 private UserService service;
	 
	 @Mock
	 private ServletConfig config;
	 
	 
	 private LoginServlet  obj;
 
	@Test
	public void verifyLoginServletObject() {		
		
		 LoginServlet obj = new LoginServlet();
		 assertNotNull(obj);
	} 

	
	 @Before
	 public void setUp() throws Exception {	
	 
	  MockitoAnnotations.initMocks(this);  
	  obj = new LoginServlet();
	  
	 //Inject the mock in the servlet
      ReflectionTestUtils.setField(obj, "service", service);
	  obj.init(config);
	 }
	 
	 
	    @Test
		public void verifyLoginServletInit() { 
		 
	       try {
			obj.init(config);
			//add verification for init method later to verify the dependencies
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
			  
		
	 
		@Test
		public void verifyGetSubmitHttpRequestToLoginServlet() { 	  
			 
			  
			  StringWriter sw = new StringWriter();
			  PrintWriter pw = new PrintWriter(sw);		
			  
			  try {
				when(response.getWriter()).thenReturn(pw);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			  //Invoke the method to test on LoginServlet object
			  
			  try {
				obj.doGet(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			  
			  
			  String result = sw.getBuffer().toString().trim();			   
			  
			  assertEquals("The Login Action doesnot expose get method", result);
			 }	

		@Test
		public void verifyPostSubmitHttpRequestToLoginServlet() { 	  
			 
			  
			  StringWriter sw = new StringWriter();
			  PrintWriter pw = new PrintWriter(sw);	
			  
			//configure mocks to play back the values
			  when(request.getParameter("uName")).thenReturn("ashok");
			  when(request.getParameter("uPass")).thenReturn("morYa");
			  
			  when(service.validateUser("ashok", "morYa")).thenReturn(true).thenReturn(false);
			  
			  try {
				when(response.getWriter()).thenReturn(pw);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			  //Invoke the method to test on LoginServlet object
			  
			
			  
			  try {
				obj.doPost(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			  
			  
			  String result = sw.getBuffer().toString().trim();			   
			  
			  assertEquals("Login successfull...", result);

			 }	

		@Test
		public void verifyLoginErrorLoginServlet() { 	  
			 
			  
			  StringWriter sw = new StringWriter();
			  PrintWriter pw = new PrintWriter(sw);	
			  
			//configure mocks to play back the values
			  when(request.getParameter("uName")).thenReturn("Baba");
			  when(request.getParameter("uPass")).thenReturn("tstPass");

			  when(service.validateUser("ashok", "morYa")).thenReturn(true).thenReturn(false);
			  
			  try {
				when(response.getWriter()).thenReturn(pw);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			  //Invoke the method to test on LoginServlet object
			  
			  try {
				obj.doPost(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			  
			  
			  String result = sw.getBuffer().toString().trim();			   
			  
			  assertEquals("Login Error...", result);

			 }	
	 
}
