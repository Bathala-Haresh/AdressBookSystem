/**
 * @author Bathala Haresh
 * @since 30/07/2021
 * Purpose: Address Book System to take user details and add to adress book and do crud operations for person details
 */
package AddressBook;

import java.io.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AddressBookFileIO {

	/**
	 * This method is used to write the contents to a file.
	 * HashMap where key=Adress book name, value=name of user
	 * @param args takes adressbook as input
	 * 
	 * @return Nothing
	 */
	public void writeData(Map<String, AddressBook> addressBook) {
		File file = new File("O:\\SpringBoot\\contacts.txt");
		BufferedWriter bf = null;
		try {
			//create new BufferedWriter for the output file
			bf = new BufferedWriter(new FileWriter(file));

			//iterate map entries
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				//put key and value separated by a colon
				bf.write(entry.getKey() + ":" + entry.getValue());

				//new line
				bf.newLine();
			}
			bf.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to read the contents from a file.
	 * HashMap where key=Adress book name, value=name of user
	 * @param args Unused.
	 * 
	 * @return the map contents of the user
	 */

	public static Map<String,  String> readData() {
		Map<String, String> mapFileContents = new HashMap<>();
		BufferedReader br = null;
		try {
			//create file object
			File file = new File("O:\\SpringBoot\\contacts.txt");

			//create BufferedReader object from the File
			br = new BufferedReader(new FileReader(file));

			String line = null;
			//read file line by line
			while ((line = br.readLine()) != null) {

				//split the line by :
				String[] parts = line.split(":");
				//String[] parts2 = line2.split(",");
				//System.out.println(parts.);

				//first part is adressbook, second is name of user
				String bookName = parts[0].trim();
				String fname = parts[1].trim();                

				mapFileContents.put(bookName, fname);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Always close the BufferedReader
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
				}
			}
		}
		return mapFileContents;
	}
}
