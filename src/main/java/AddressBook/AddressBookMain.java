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
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add ");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			myObj.add();
		}
	}

}