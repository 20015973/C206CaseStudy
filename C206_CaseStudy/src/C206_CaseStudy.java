
import java.util.ArrayList;
import java.util.Scanner;


public class C206_CaseStudy {

    static Scanner sc = new Scanner(System.in);
    static User currentUser;
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    static ArrayList<Order> orders = new ArrayList<Order>();
    static ArrayList<Bill> bills = new ArrayList<Bill>();
    
    public static void showMenuStudentTeacher() {
        System.out.println("1) View weekly menu");
        System.out.println("2) Add lunch box order");
        System.out.println("3) View lunch box order");
        System.out.println("4) Delete lunch box order");
        System.out.println("5) Add order bill");
        System.out.println("6) View order bill");
    }

    public static void showMenuAdmin() {
        System.out.println("1) Add user account");
        System.out.println("2) View user account");    
        System.out.println("3) Delete user account");  
        System.out.println("4) Add menu items");  
        System.out.println("5) View menu items");  
        System.out.println("6) Delete menu items");  
        System.out.println("7) Create monthly menu");  
        System.out.println("8) View monthly menu");  
        System.out.println("9) Delete monthly menu"); 
        System.out.println("10) Delete order bill"); 
    }
    public static void main (String args[]) {
        //get user
        getUser();
        //show menu
        if(currentUser.userType == "admin"){
            while(true){
                showMenuAdmin();
                int selection = sc.nextInt();
                if(selection == 1){
                    System.out.println("Enter user name:");
                    String username = sc.next();
                    User u = new User(username, "studentteacher");
                    users.add(u);
                }
                if(selection == 2){
                    //display all user accounts:
                    System.out.println("Showing all users:");
                    for(int i= 0; i< users.size(); i++) {
                        int index = i+0;
                        System.out.println(index+") "+users.get(i).username);
                    }
                }
                if(selection == 3){
                    //remove user account
                    System.out.println("Enter username to delete");
                    String username = sc.next();
                    int index = -1;
                    for(int i=0; i<users.size(); i++){
                        if(users.get(i).username.equals(username)){
                            index = i;
                            break;
                        }
                    }
                    if(index >= 0){
                        users.remove(index);
                        System.out.println("User deleted!");
                    } else {
                        System.out.println("User doesn't exist");
                    }
                }
                if(selection == 4){
                    System.out.println("Enter Menu Item ID: ");
                    int id = sc.nextInt();
                    System.out.println("Enter Menu Item name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Menu Item price: ");
                    String price = sc.next();
                    menuItems.add(new MenuItem(id, name, price));
                }
                if(selection == 5){
                    System.out.println("Showing all menu items:");
                    for(int i= 0; i< menuItems.size(); i++) {
                        menuItems.get(i).show();
                        System.out.println();
                    }
                }
                if(selection == 6){
                    //remove menu item
                    System.out.println("Enter ID of menu item to delete");
                    int id = sc.nextInt();
                    int index = -1;
                    for(int i=0; i<menuItems.size(); i++){
                        if(menuItems.get(i).ID == id){
                            index = i;
                            break;
                        }
                    }
                    if(index >= 0){
                        menuItems.remove(index);
                        System.out.println("Menu Item deleted!");
                    } else {
                        System.out.println("Menu Item doesn't exist");
                    }
                }

                }
                if(selection == 7){

                }
                if(selection == 8){

                }
                if(selection == 9){

                }
                if(selection == 10){

                    }
                }
            }
        
        if(currentUser.userType == "studentteacher"){
            showMenuStudentTeacher();
            //get selection
            int selection = sc.nextInt();
            if(selection == 1){

              
                    
            	

            }
            if(selection == 2){
            	 System.out.println("Enter order ID: ");
                 int id = sc.nextInt();
                 System.out.println("Enter order Date: ");
                 String date = sc.next();
                 System.out.println("Enter order meal: ");
                 String meal = sc.nextLine();
                 System.out.println("Enter order fruit: ");
                 String fruit = sc.nextLine();
                 System.out.println("Enter order drink: ");
                 String drink = sc.nextLine();
                 Order o = new Order(id, date, meal, fruit, drink);
                 orders.add(o);
                 System.out.println("Order created! ");
             }

            }
            if(selection == 3){
            	 System.out.println("Showing all orders...");
                 showAllOrders();

            }
            if(selection == 4){
            	 System.out.println("Enter ID of order to delete");
                 int id = sc.nextInt();
                 int index = -1;
                 for(int i=0; i<orders.size(); i++){
                     if(orders.get(i).ID == id){
                         index = i;
                         break;
                     }
                 }
                 if(index >= 0){
                     orders.remove(index);
                     System.out.println("Order deleted!");
                 } else {
                     System.out.println("Order doesnt exist");
                 }
             }

            
            if(selection == 5){
            	
                     System.out.println("Select which order id you would like to bill: ");
                     showAllOrders();
                     int id = sc.nextInt();
                     Order o = getOrderById(id);
                     System.out.println("Enter the amount of the bill: ");
                     String amount = sc.next();
                     Bill b = new Bill(id, o.date, amount, o.meal, o.drink, o.fruit);
                     bills.add(b);
                     System.out.println("Bill added!");

            }
            if(selection == 6){
            	 showAllBills();

            }

}
}
    public static void showAllOrders() {
        for(int i=0; i< orders.size(); i++){
            orders.get(i).show();
        }  
    }
    public static void showAllBills() {
        for(int i=0; i< orders.size(); i++){
            orders.get(i).show();
        }  
    }

    public static void getUser() {
        System.out.println("Enter username: ");
        String username = sc.next();
        if(username.equals("admin")) {
            currentUser = new User("admin", "admin");
        } else {
            for(int i=0; i< users.size(); i++){
                User u = users.get(i);
                if(u.username.equals(username)){
                    //user found
                    currentUser = new User(username,"studentteacher");
                }
            }
        }
    }

}


class User {
    String username;
    String userType;
    
    User(String username, String userType){
        this.username = username;
        this.userType = userType;
    }
}
class MenuItem {
	  int ID;
	  String name;
	  String price;

	  public MenuItem(int ID, String name, String price) {
	    this.ID = ID;
	    this.name = name;
	    this.price = price;
	  }

	  public void show() {
	    System.out.println("ID: " + ID);
	    System.out.println("Name: " + name);
	    System.out.println("Price: $" + price);
	  }
}
class Order {
    int ID;
    String date;
    String meal;
    String fruit;
    String drink;
    public Order(int ID, String date, String meal, String fruit, String drink) {
        this.ID = ID;
        this.date = date;
        this.meal = meal;
        this.fruit = fruit;
        this.drink = drink;
    }

    public void show() {
        System.out.println("Order ID: "+ ID);
        System.out.println("Date: "+ date);
        System.out.println("meal: "+ meal);
        System.out.println("fruit: "+ fruit);
        System.out.println("drink: "+ drink);
    }
}
class Bill {
    int ID;
    String date;
    String amount; 
    String meal;
    String drink;
    String fruit;

    public Bill(int ID, String date, String amount, String meal, String drink, String fruit) {
        this.ID = ID;
        this.date = date;
        this.amount = amount;
        this.meal = meal;
        this.drink = drink;
        this.fruit = fruit;
    }

    public void show() {
        System.out.println("Bill/Order ID: "+ ID);
        System.out.println("Amount: $"+ amount);
        System.out.println("Date: "+ date);
        System.out.println("meal: "+ meal);
        System.out.println("fruit: "+ fruit);
        System.out.println("drink: "+ drink);
    }
}

