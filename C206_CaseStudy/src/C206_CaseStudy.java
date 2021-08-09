
import java.util.ArrayList;
import java.util.Scanner;

public class C206_CaseStudy {

    static Scanner sc = new Scanner(System.in);
    static User currentUser;
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    
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

            }
            if(selection == 3){

            }
            if(selection == 4){

            }
            if(selection == 5){

            }
            if(selection == 6){

            }

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
}

