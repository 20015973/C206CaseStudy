import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudyTest {
private MonthlyMenu mm1;
private MonthlyMenu mm2;

private Order order1;
private Order order2;

private ArrayList<MonthlyMenu> monthlyMenus;

private ArrayList<Order> orders;
@Before		
public void setUp() throws Exception{
	mm1 = new MonthlyMenu(1, "12/8/21","fish n chips","dumpling","carrot");
    mm2 = new MonthlyMenu(2,"12/8/21","Chicken Burger", "Noodle soup","corn");
    
	order1=new Order(1,"12/12/2021","Sushi","Orange","Tea");
	order2=new Order(2,"13/12/2021","Chicken Rice","Apple","Coffee");
	
	monthlyMenus=new ArrayList<MonthlyMenu>();
	orders=new ArrayList<Order>();
	
}
public void testAddMonthlyMenu() {
    assertNotNull("Test if there is valid MonthlyMenu arraylist to add to",monthlyMenus);
    monthlyMenus.add(mm1);
    assertEquals("Test if that MonthlyMenu arraylist size is 1?",1,monthlyMenus.size());
    assertSame("Test that MonthlyMenu added is not the same as the first monthlymenu in the list", mm1,monthlyMenus.get(0));
   
}
public void testViewAllMonthlyMenu() {
    assertNotNull("Test if there is valid Order arraylist to add to", monthlyMenus);
   
    monthlyMenus.add(mm1);
    monthlyMenus.add(mm2);
   
    String testOutput=("Viewing monthly menu:\n Monthly menu ID: 1\n Date: 12/8/2021\n western: fish n chips\n asian: dumpling\n veggie: carrot");
    testOutput+=("Viewing monthly menu:\n Monthly menu ID: 2\n Date: 12/8/2021\n western: Chicken burger\n asian: Noodle Soup\n veggie: corn");
   
    assertEquals("Check that ViewAllCategory", testOutput,monthlyMenus);
   
}
public void testDeleteMonthlyMenu() {
    assertNotNull("Test if the list is empty but not null",monthlyMenus);
    monthlyMenus.add(mm1);
    monthlyMenus.add(mm2);
   
    assertEquals("Test if the monthlymenu arraylist size is 2?",2,monthlyMenus);
    Boolean isDelete=monthlyMenus.remove(mm1);
    assertTrue(isDelete);
}
public void testAddOrder() {
	assertNotNull("Test if there is valid Order arraylist to add to",orders);
	orders.add(order1);
	assertEquals("Test if that Order arraylist size is 1?",1,orders.size());
	
	assertSame("Test that Order added is not the same as the first category in the list", order1,orders.get(0));
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
		monthlyMenus=null;
        mm1=null;
        mm2=null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
