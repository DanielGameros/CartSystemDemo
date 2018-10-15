package cartSystemExample;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainEntryPoint {
	public static void main(String[] args) throws FileNotFoundException {
		AppSystem app = new AppSystem();
		CartSystem cart = new CartSystem();
		Scanner reader = new Scanner(System.in);
		Integer choice = 0;
		boolean success = false;
		
		while (choice != 7) {
			menu();
			choice = reader.nextInt();
			
			/**
			 * check that the choice is one of the available options,and if not print error message
			 * and prompt user again
			 */
			do {
				if(choice <1 || choice>=8 ) {
					System.out.println("Invalid number. Enter a number from 1 to 8 ");
					break;
				}
				else success = true;
			}while(!success);
			
			switch (choice) {
			case 1:
				Item item = new Item();
				reader.nextLine();
				System.out.print("\nEnter the item name:\n");
				item.setItemName(reader.nextLine());
				System.out.print("\nEnter a description for the item:\n");
				item.setItemDesc(reader.nextLine());
				System.out.print("\nEnter the item's price:\n");
				item.setItemPrice(reader.nextDouble());
				System.out.print("\nEnter the quantity available in the System:\n");
				item.setAvailableQuantity(reader.nextInt());
				System.out.println(item.getItemName());
				if (app.add(item)) {
					System.out.println("Item successfully added");
				} else {
					System.out.println("Try Again");
				}
				break;
			case 2:
				try {
					app.display();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Enter the name of the item");
				reader.nextLine();
				String item_name = reader.nextLine();
				if (cart.add(app.getItemCollection().get(item_name))) {
					System.out.println("Item successfully added");
				} else {
					System.out.println("Invalid or Unavailable Item, Please Try Again");
				}
				;
				break;
			case 3:
				try {
					cart.display();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					app.display();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					cart.display();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Enter the name of the item");
				reader.nextLine();
				item_name = reader.nextLine();
				if (cart.remove(item_name) != null) {
					System.out.println(item_name + " was removed from the cart");
				} else {
					System.out.println("Invalid Item, Please Try Again");
				}
				break;
			case 6:
				try {
					app.display();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Enter the name of the item");
				reader.nextLine();
				item_name = reader.nextLine();
				if (app.remove(item_name) != null) {

					System.out.println(item_name + " was removed from the System");
					if (cart.remove(item_name) != null) {
						System.out.println(item_name + " was also removed from the cart");
					}
				} else {
					System.out.println("Invalid Item, Please Try Again");
				}
				break;
			case 7:
				System.out.println("\nByyyeee!!");
				break;
			}
		}
		reader.close();
	}

	public static void menu() {
		System.out.println("\nChoose an action:");
		System.out.println("1. Add item to System");
		System.out.println("2. Add item to Cart");
		System.out.println("3. Display Cart");
		System.out.println("4. Display System");
		System.out.println("5. Remove item from Cart");
		System.out.println("6. Remove item from System");
		System.out.println("7. Quit");
}
}