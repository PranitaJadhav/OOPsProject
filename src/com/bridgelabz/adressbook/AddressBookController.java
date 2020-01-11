package com.bridgelabz.adressbook;

import java.io.IOException;

public class AddressBookController {

	public static void main(String[] args) throws Exception {
		Utility utility = new Utility();
		AddressBookManagerImplementation implementation1 = new AddressBookManagerImplementation();
		AdressBookImplementation implementation2 = new AdressBookImplementation();
		int loop = 0;
		String existingaddressBook = "";
		while (loop == 0) {

			System.out.println("\t\t\t\t\tAddress Book");
			System.out.println("\t\t\t 1. create a new file");
			System.out.println("\t\t\t 2. Open a existing file");
			System.out.println("\t\t\t 3. save a current file");
			System.out.println("\t\t\t 4. Save As");
			System.out.println("\t\t\t 5. Close the current file");

			int choice = utility.read_Integer();

			switch (choice) {
			case 1:
				implementation1.create();
				implementation1.close(existingaddressBook);

				break;

			case 2:
				implementation1.close(existingaddressBook);
				implementation1.readAddress();
				
				  System.out.println("Enter the name of file you want to open");
				 existingaddressBook = utility.read_String();
				 

				// if(implementation1.checkAddress(existingaddressBook)) {

				System.out.println("Your file is exist");
				//if (implementation2.read()) {
					implementation2.read1(existingaddressBook);
					System.out.println("Enter the choice");

					int i = 0;
					while (i == 0) {
						System.out.println("1. Addfile");
						System.out.println("2.Edit file");
						System.out.println("3.Remove file");
						System.out.println("4.Sort by name");
						System.out.println("5. Sort by zip");
						System.out.println("6.Display");
						System.out.println("7.Exit");

						int c = utility.read_Integer();

						switch (c) {

						case 1:
							implementation2.add();
							// implementation2.save(existingaddressBook);
							break;
						case 2:
							//implementation2.show();
							 implementation2.edit1();
							break;
						case 3:
							implementation2.remove();
							break;
						case 4:
							implementation2.sortByName();
							break;
						case 5:
							implementation2.sortByZip();
							break;
						case 6:
							implementation2.printAll();
							break;
						case 7:
							System.out.println("Traversing");
							i = 1;
							break;
						    default:
							System.out.println("Enter valid choice");
							i = 1;
							break;
						}// inner switch
					} // while
				//} // if

				/*else {

					System.out.println("File does not exist");
				} // else
*/				//break;

			case 3:
				implementation2.save(existingaddressBook);
				break;
			case 4:
				implementation1.saveAs();
				break;
			case 5:
				System.out.println("Closing the adress book");

				loop = 1;
				break;
			default:
				System.out.println("Sorry..! Something went wrong");

			}// switch

		}
	}

}
