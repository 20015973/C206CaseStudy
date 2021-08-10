
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_Austin_Junitt {
private User user1;
private User user2;

private ArrayList<User> User;
@Before		
public void setUp() throws Exception{
	user1=new User("John", "0");
	user2=new User("Austin", "1");
	
	User=new ArrayList<User>();
	
}
public void testAddUser() {
	assertNotNull("Test if there is valid User arraylist to add to",User);
	User.add(user1);
	assertEquals("Test if that User arraylist size is 1?",1,User.size());
	
	assertSame("Test that User added is not the same as the first category in the list", user1,User.get(0));
}

public void testViewAllUser() {
	assertNotNull("Test if there is valid User arraylist to add to", User);

	User.add(user1);
	User.add(user2);
	
	
	String testOutput=("Showing all users: \n 0) John \n= 1)Austin ");

	assertEquals("Check that ViewAllUser", testOutput,User);
}
public void testDeleteOrder() {
	assertNotNull("Test if the list is empty but not null",User);
	User.add(user1);
	User.add(user2);
	
	assertEquals("Test if the order arraylist size is 2",2,User);
	
	Boolean isDelete=User.remove(user1);
	assertTrue(isDelete);
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
     
	@After
	public void tearDown() throws Exception {
		User=null;
		user1=null;
		user2=null;
				
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}