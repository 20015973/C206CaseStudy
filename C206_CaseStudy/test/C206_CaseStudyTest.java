import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudyTest {
private Order order1;
private Order order2;




private ArrayList<Order> orders;


@Before		
public void setUp() throws Exception{
	order1=new Order(1,"12/12/2021","Sushi","Orange","Tea");
	order2=new Order(2,"13/12/2021","Chicken Rice","Apple","Coffee");
    
	
	orders=new ArrayList<Order>();

	
}
public void testAddOrder() {
	assertNotNull("Test if there is valid Order arraylist to add to",orders);
	orders.add(order1);
	assertEquals("Test if that Order arraylist size is 1?",1,orders.size());
	
	assertSame("Test that Order added is not the same as the first Order in the list", order1,orders.get(0));
}


public void testViewAllOrder() {
	assertNotNull("Test if there is valid Order arraylist to add to", orders);

    orders.add(order1);
	orders.add(order2);
	

	
	String testOutput=("Showing all orders...\n Order ID: 1 \nDate: 12/12/2021 \nmeal: Sushi \nfruit: Orange \ndrink: Tea");
	testOutput+=("Showing all orders...\n Order ID: 2 \nDate: 13/12/2021 \nmeal: Chicken Rice \nfruit: Apple \ndrink: Tea");

	assertEquals("Check that ViewAllCategory", testOutput,orders);
}

	
	


public void testDeleteOrder() {
	assertNotNull("Test if the list is empty but not null",orders);
	orders.add(order1);
	orders.add(order2);
	
	assertEquals("Test if the order arraylist size is 2?",2,orders);
	
	Boolean isDelete=orders.remove(order1);
	assertTrue(isDelete);
}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
     
	@After
	public void tearDown() throws Exception {
		orders=null;
		order1=null;
		order2=null;
		
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
