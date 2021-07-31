/**
 * @author Bathala Haresh
 * @since 30/07/2021
 * Purpose: Address Book System to take user details and add to adress book and do crud operations for person details
 */
package AddressBook;

import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook {
	Contacts contact = new Contacts();
	Scanner sc = new Scanner(System.in);

	public void add() {

		// Takes input from user

		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter last Name: ");
		String lastName = sc.nextLine();
		System.out.println("Enter your address: ");
		String address = sc.nextLine();
		System.out.println("Enter your city: ");
		String city = sc.nextLine();
		System.out.println("Enter your state: ");
		String state = sc.nextLine();
		System.out.println("Enter zip code of your area: ");
		Long zipCode = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter phone number: ");
		Long phoneNum = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter your EMail ID: ");
		String email = sc.nextLine();

		// calling the set method

		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setAddress(address);
		contact.setCity(city);
		contact.setState(state);
		contact.setZipCode(zipCode);
		contact.setPhoneNumber(phoneNum);
		contact.setEmail(email);
	}

	// ability to edit existing contact
	public void editContact() {
		System.out.println("Enter First Name of Persion");
		String editName = sc.nextLine();
		if (editName.equalsIgnoreCase(contact.firstName)) {
			add();
			// System.out.println(contact);
		} else {
			System.out.println("Invalid Name......!");
			System.out.println("Please enter valid First Name");
			editContact();
		}
	}

	public void delete() {
		System.out.println("Enter First Name of Persion");
		String editName = sc.nextLine();
		if (editName.equals(contact.firstName)) {
			System.out.println("you deleted " + contact.firstName + " data");

			contact = null;
		}
	}
	
	public void showContact() {
		System.out.println(contact.toString());
	}

}