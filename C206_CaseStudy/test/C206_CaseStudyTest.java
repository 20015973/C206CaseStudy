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

private Bill orderbill1;
private Bill orderbill2;

private MenuItem mi1;
private MenuItem mi2;






private ArrayList<MonthlyMenu> monthlyMenus;
private ArrayList<MenuItem> menuItem;


private ArrayList<Order> orders;
private ArrayList<Bill> bills;


@Before		
public void setUp() throws Exception{
	mm1 = new MonthlyMenu(1, "12/8/21","fish n chips","dumpling","carrot");
    mm2 = new MonthlyMenu(2,"12/8/21","Chicken Burger", "Noodle soup","corn");
    
	order1=new Order(1,"12/12/2021","Sushi","Orange","Tea");
	order2=new Order(2,"13/12/2021","Chicken Rice","Apple","Coffee");
	
	orderbill1=new Bill(1,"12/12/2021", "$12.50", "Sushi","Orange","Tea");
	orderbill2=new Bill(2,"13/12/2021", "$13.50", "Chicken Rice", "Apple", "Coffee");
	
	mi1 = new MenuItem(1, "Chicken Rice", "$3.50");
    mi2 = new MenuItem(2, "Laksa", "$4.00");
    
	
	monthlyMenus=new ArrayList<MonthlyMenu>();
	orders=new ArrayList<Order>();
	bills=new ArrayList<Bill>();
	menuItem=new ArrayList<MenuItem>();

	
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

public void testAddBill() {
	assertNotNull("Test if there is valid OrderBill arraylist to add to",bills);
	bills.add(orderbill1);
	assertEquals("Test if that OrderBill arraylist size is 1?",1,bills.size());
	assertSame("Test that OrderBill added is not the same as the first OrderBill in the list", orderbill1,bills.get(0));
	
	
}
public void testDeleteOrderBills() {
	assertNotNull("Test if the list is empty but not null",orders);
	bills.add(orderbill1);
	
	assertEquals("Test if the order arraylist size is 2?",2,orders);
	
	Boolean isDelete=bills.remove(orderbill1);
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
        
        orderbill1 =null;
	}

public void testAddMenuItem() {
    assertNotNull("Test if we can add into MenuItem Arraylist",menuItem);
    menuItem.add(mi1);
    assertEquals("Test if the Menuitem Arraylist size is 1?",1,menuItem.size());
    assertSame("Test that MenuItem added is not the same as the first MenuItem in the list", mi1,menuItem.get(0));
   
}

public void testDeleteMenuItem() {
    assertNotNull("Test if list is not null but empty.",menuItem);
    monthlyMenus.add(mm1);
    monthlyMenus.add(mm2);
   
    assertEquals("Test if the MenuItem arraylist size is 3?",3,menuItem);
    Boolean isDelete=monthlyMenus.remove(mm1);
    assertTrue(isDelete);
}

public void testViewMenuItem() {
	assertNotNull("Test if there is valid MenuItem arraylist to add to", menuItem);

    menuItem.add(mi1);
	menuItem.add(mi2);
	

	
	String testOutput=("Showing all orders...\n Menu ID: 1 \nmeal: Chicken Rice \nprice: $3.50");
	testOutput+=("Showing all orders...\n Menu ID: 2 \nmeal: Laksa \nprice: $4.00");

	assertEquals("Check that ViewAllCategory", testOutput,menuItem);
}

	


	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
