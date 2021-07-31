/**
 * @author Bathala Haresh
 * @since 30/07/2021
 * Purpose: Address Book System to take user details and add to adress book and do crud operations for person details
 */
  
package AddressBook;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		AddressBook myObj = new AddressBook();
		System.out.println("Welcome to Address Book System");
		myObj.add();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Edit \n2.Delete ");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			myObj.editContact();
			break;
		case 2:
			myObj.delete();
			break;
		}
	}

}