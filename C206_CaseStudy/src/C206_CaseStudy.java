import java.util.ArrayList;
import java.util.Scanner;

public class C206_CaseStudy {

	static Scanner sc = new Scanner(System.in);
	static User currentUser;
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	static ArrayList<MonthlyMenu> monthlyMenus = new ArrayList<MonthlyMenu>();
	static ArrayList<Order> orders = new ArrayList<Order>();
	static ArrayList<Bill> bills = new ArrayList<Bill>();

	public static void showcreate() {
		Helper.line(30, "-");
		System.out.println("1) Add user account");
		System.out.println("2) View user account");
		System.out.println("3) Delete user account");
		System.out.println("4) Back to select user");
		Helper.line(30, "-");

	}

	public static void showMenuStudentParent() {
		Helper.line(30, "-");
		System.out.println("1) View weekly menu");
		System.out.println("2) Add lunch box order");
		System.out.println("3) View lunch box order");
		System.out.println("4) Delete lunch box order");
		System.out.println("5) Back to select user");
		Helper.line(30, "-");
	}

	public static void showMenuAdmin() {
		Helper.line(30, "-");
		System.out.println("1) Add menu items");
		System.out.println("2) View menu items");
		System.out.println("3) Delete menu items");
		System.out.println("4) Create monthly menu");
		System.out.println("5) View monthly menu");
		System.out.println("6) Delete monthly menu");
		System.out.println("7) Add order bill");
		System.out.println("8) View order bill");
		System.out.println("9) Delete order bill");
		System.out.println("10) Back to select user");
		Helper.line(30, "-");
	}

	public static void main(String args[]) {
		while (true) {

			Helper.line(30, "-");
			System.out.println("1) Administrator Access");
			System.out.println("2) Create user for Student/Parent");
			System.out.println("Or input Name to access to Lunchbox Access System");
			Helper.line(30, "-");
			String uname = sc.next();
			if (uname.equals("q")) {
				System.out.println("Goodbye");
				return;
			}
			if (uname.equals("1")) {
				currentUser = new User("admin", "admin");
			}
			if (uname.equals("2")) {
				currentUser = new User("createa", "create");
			} else {
				for (int i = 0; i < users.size(); i++) {
					User us = users.get(i);
					if (us.username.equals(uname)) {
						// user found
						currentUser = new User(uname, "studentparent");
					}
				}
			}
			// show menu
			if (currentUser.userType.equals("admin")) {
				while (true) {
					showMenuAdmin();
					int selection = sc.nextInt();
					if (selection == 1) {
						System.out.println("Enter Menu Item ID: ");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Menu Item name: ");
						String name = sc.nextLine();
						System.out.println("Enter Menu Item price: ");
						String price = sc.next();
						menuItems.add(new MenuItem(id, name, price));
					}
					if (selection == 2) {
						System.out.println("Showing all menu items:");
						for (int i = 0; i < menuItems.size(); i++) {
							menuItems.get(i).show();
							System.out.println();
						}
					}
					if (selection == 3) {
						// remove menu item
						System.out.println("Enter ID of menu item to delete");
						int id = sc.nextInt();
						int index = -1;
						for (int i = 0; i < menuItems.size(); i++) {
							if (menuItems.get(i).ID == id) {
								index = i;
								break;
							}
						}
						if (index >= 0) {
							menuItems.remove(index);
							System.out.println("Menu Item deleted!");
						} else {
							System.out.println("Menu Item doesn't exist");
						}
					}
					if (selection == 4) {
						System.out.println("Creating monthly menu...");
						System.out.println("Enter ID of monthly menu");
						int id = sc.nextInt();
						System.out.println("Enter date of monthly menu");
						String date = sc.next();

						// Western
						System.out.println("Select which menu item id is for western:");
						for (int i = 0; i < menuItems.size(); i++) {
							menuItems.get(i).show();
							System.out.println();
						}
						int idWestern = sc.nextInt();
						String western = getMenuItemNameById(idWestern);

						// asian
						System.out.println("Select which menu item id is for asian:");
						for (int i = 0; i < menuItems.size(); i++) {
							menuItems.get(i).show();
							System.out.println();
						}
						int idAsian = sc.nextInt();
						String asian = getMenuItemNameById(idAsian);

						// veggie
						System.out.println("Select which menu item id is for veggie:");
						for (int i = 0; i < menuItems.size(); i++) {
							menuItems.get(i).show();
							System.out.println();
						}
						int idVeggie = sc.nextInt();
						String veggie = getMenuItemNameById(idVeggie);

						MonthlyMenu monthlyMenu = new MonthlyMenu(id, date, western, asian, veggie);
						monthlyMenus.add(monthlyMenu);
						System.out.println("monthly menu added...");
					}
					if (selection == 5) {
						System.out.println("Viewing monthly menu: ");
						for (int i = 0; i < monthlyMenus.size(); i++) {
							monthlyMenus.get(i).show();
							System.out.println();
						}
					}
					if (selection == 6) {
						System.out.println("Deleting monthly menu...");
						// remove menu item
						System.out.println("Enter ID of monthly menu to delete");
						int id = sc.nextInt();
						int index = -1;
						for (int i = 0; i < monthlyMenus.size(); i++) {
							if (menuItems.get(i).ID == id) {
								index = i;
								break;
							}
						}
						if (index >= 0) {
							menuItems.remove(index);
							System.out.println("Monthly Menu deleted!");
						} else {
							System.out.println("Monthly Menu doesnt exist");
						}
					}
					if (selection == 7) {
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
					if (selection == 8) {
						showAllBills();
					}
					if (selection == 9) {
						System.out.println("Deleting order bill...");
						// show all orders
						showAllOrders();
						System.out.println("Enter ID of order to delete");
						int id = sc.nextInt();
						int index = -1;
						for (int i = 0; i < orders.size(); i++) {
							if (orders.get(i).ID == id) {
								index = i;
								break;
							}
						}
						if (index >= 0) {
							orders.remove(index);
							System.out.println("Order deleted!");
						} else {
							System.out.println("Order doesnt exist");
						}
					}
					if (selection == 10) {
						System.out.println("Going back to select user");
						break;
					}
				}
			}
			if (currentUser.userType.equals("studentparent")) {
				while (true) {
					showMenuStudentParent();
					// get selection
					int selection = sc.nextInt();
					if (selection == 1) {
						System.out.println("Viewing monthly menu: ");
						for (int i = 0; i < monthlyMenus.size(); i++) {
							monthlyMenus.get(i).show();
							System.out.println();
						}
					}
					if (selection == 2) {
						System.out.println("Enter order ID: ");
						int id = sc.nextInt();
						System.out.println("Enter order Date: ");
						String date = sc.next();
						sc.nextLine();
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
					if (selection == 3) {
						System.out.println("Showing all orders...");
						showAllOrders();
					}
					if (selection == 4) {
						System.out.println("Enter ID of order to delete");
						int id = sc.nextInt();
						int index = -1;
						for (int i = 0; i < orders.size(); i++) {
							if (orders.get(i).ID == id) {
								index = i;
								break;
							}
						}
						if (index >= 0) {
							orders.remove(index);
							System.out.println("Order deleted!");
						} else {
							System.out.println("Order doesnt exist");
						}
					}

					if (selection == 5) {
						System.out.println("Going back to select user");
						break;
					}
				}

			} // Create user
			if (currentUser.userType.equals("create")) {
				while (true) {
					showcreate();
					int selection = sc.nextInt();
					if (selection == 1) {
						System.out.println("Enter user name:");
						String username = sc.next();
						User u = new User(username, "studentparent");
						users.add(u);
					}
					if (selection == 2) {
						// display all user accounts:
						System.out.println("Showing all users:");
						for (int i = 0; i < users.size(); i++) {
							int index = i + 0;
							System.out.println(index + ") " + users.get(i).username);
						}
					}
					if (selection == 3) {
						// remove user account
						System.out.println("Enter username to delete");
						String username = sc.next();
						int index = -1;
						for (int i = 0; i < users.size(); i++) {
							if (users.get(i).username.equals(username)) {
								index = i;
								break;
							}
						}
						if (index >= 0) {
							users.remove(index);
							System.out.println("User deleted!");
						} else {
							System.out.println("User doesn't exist");
						}
					}
					if (selection == 4) {
						System.out.println("Going back to select user");
						break;
					}
				}
			}
		}
		// Add user account
	}

	public static void showAllBills() {
		for (int i = 0; i < orders.size(); i++) {
			orders.get(i).show();
		}
	}

	public static void showAllOrders() {
		for (int i = 0; i < orders.size(); i++) {
			orders.get(i).show();
		}
	}

	public static Order getOrderById(int id) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).ID == id) {
				return orders.get(i);
			}
		}
		return null;
	}

	public static String getMenuItemNameById(int id) {
		for (int i = 0; i < menuItems.size(); i++) {
			if (menuItems.get(i).ID == id) {
				return menuItems.get(i).name;
			}
		}
		return "";
	}

}

class User {
	String username;
	String userType;

	User(String username, String userType) {
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

class MonthlyMenu {
	int ID;
	String date;
	String western;
	String asian;
	String veggie;

	public MonthlyMenu(int ID, String date, String western, String asian, String veggie) {
		this.ID = ID;
		this.date = date;
		this.western = western;
		this.asian = asian;
		this.veggie = veggie;
	}

	public void show() {
		System.out.println("Monthly menu ID: " + ID);
		System.out.println("Date: " + date);
		System.out.println("western: " + western);
		System.out.println("asian: " + asian);
		System.out.println("veggie: " + veggie);
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
		System.out.println("Order ID: " + ID);
		System.out.println("Date: " + date);
		System.out.println("meal: " + meal);
		System.out.println("fruit: " + fruit);
		System.out.println("drink: " + drink);
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
		System.out.println("Bill/Order ID: " + ID);
		System.out.println("Amount: $" + amount);
		System.out.println("Date: " + date);
		System.out.println("meal: " + meal);
		System.out.println("fruit: " + fruit);
		System.out.println("drink: " + drink);
	}
}