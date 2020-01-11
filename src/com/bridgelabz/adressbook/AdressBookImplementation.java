/*purpose to implement *
 * 
 */
package com.bridgelabz.adressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class AdressBookImplementation implements AdressBook {
	Scanner sc = new Scanner(System.in);
	
	Utility utility = new Utility();
	public static List<Person> list = new ArrayList<Person>();
	
	ObjectMapper mapper = new ObjectMapper();
	
	Person person = new Person();
	
	Address address = new Address();

	public List<Person> add() {
		list.add(addUser());
		for (Person p : list) {
			System.out.println(p.toString());
		}
		return list;
	}

	// to add a person in list
	private Person addUser() {
		Person person = new Person();
		Address address = new Address();
		System.out.println("Enter the first name");
		person.setFirstName(utility.read_String());

		System.out.println("Enter the last name");
		person.setLastName(utility.read_String());

		System.out.println("Enter the city name");
		address.setCity(utility.read_String());

		System.out.println("Enter the state name");
		address.setState(utility.read_String());

		System.out.println("Enter the zip name");
		address.setZip(utility.read_Integer());

		System.out.println("Enter the PhoneNo name");
		person.setPhoneNo(utility.read_Integer());

		person.setAdress(address);

		return person;

	}

	int count = 0;

	public static void show() {
		for (Person person : list) {
			System.out.println(person.firstName);
		}
	}

	
	  public void edit1( ) {
	  
	  System.out.println("Enter First name"); 
	  String firstName1 = utility.read_String();
	  
	  
	  for(Person p: list) {
	  System.out.println(p.toString());
	  if(firstName1.equalsIgnoreCase(p.getFirstName())) {
		  count++;
		  
		  System.out.println(p.getFirstName());
	  System.out.println("DataFound to edit");
	  System.out.println("\t 1: To edit adress  \t 2: To edit PhoneNumber"); 
	  int choice = utility.read_Integer(); 
	  switch(choice) 
	  {
	  case 1: editPhoneNoAddress(p,1);
	  		   break;
	  case 2: editPhoneNoAddress(p,2);
	  			break;
	  default:System.out.println("Please enter valid choice");
	  			break;
	  
	  
	  }//switch 
	 }//if 
  }//for
	  
	  
	  if(count == 0) {
	  
	  System.out.println("sorry..! No such data found"); 
	  } 
	  
	  }
	 
	private void editPhoneNoAddress(Person p, int i) {
		switch (i) {

		case 1:
			System.out.println("Enter the State to change");
			p.adress.setState(utility.read_String());

			System.out.println("Enter the city to change");
			p.adress.setCity(utility.read_String());

			System.out.println("Enter the zip to change");
			p.adress.setZip(utility.read_Integer());

			System.out.println("New Adress is updated");

			break;

		case 2:
			System.out.println("Enter the phoneNumber to change");
			p.setPhoneNo(utility.read_Integer());
			System.out.println("Phone number is changed");
		}

	}

	public void remove() {

		System.out.println("Enter the First name to remove");
		String firstName = utility.read_String();
		List<Person> toRemove = new ArrayList();

		for (Person p : list) {

			if (firstName.equals(p.getFirstName())) {

				System.out.println("Data Deleted");
				toRemove.add(p);
				count++;
			}

		}

		list.removeAll(toRemove);

		if (count == 0) {
			System.out.println("Sorry...!No such data found");
		}

	}

	@Override
	public void printAll() {

		for (Person p : list) {

			System.out.println(p.toString());
		}
	}

	
	  public boolean read1(String existingAddressBook) throws Exception { 
		  ObjectMapper objectMapper = new ObjectMapper(); try { BufferedReader reader = new
	      BufferedReader(new FileReader("/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/AddressBook/" + existingAddressBook + ".json"));
		 String arrayToJson;
		 if ((arrayToJson = reader.readLine()) != null) {
	  
	  TypeReference<ArrayList<Person>> type = new TypeReference<ArrayList<Person>>() { }; 
	  list = objectMapper.readValue(arrayToJson, type); reader.close();
	  return true;
	  }
	  } catch(IOException e) { 
		  e.printStackTrace(); 
		  }
		return false;
	  
	  }
	 

	public boolean read() throws IOException {
		System.out.println("Enter the file name you want to open");
		String fileName = sc.nextLine();
		File file1 = new File(fileName);
		FileInputStream input = new FileInputStream(
				"/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/AddressBook/" + file1 + ".json");
		int r = 0;
		while ((r = input.read()) != -1) {
			System.out.println();

		}
		return true;

	}

	public void close(String existingaddressBook) {

		list.clear();
	}

	public void sortByName() {

		Collections.sort(list, new SortByName());
		for (Person person : list) {
			System.out.println(person.toString());
		}
	}

	public void sortByZip() {

		Collections.sort(list, new SortByZip());
		for (Person person : list) {
			System.out.println(person.toString());
		}
	}

	public void save(String existingaddressBook) {
		try {
			mapper.writeValue(new File("/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/AddressBook/"
					+ existingaddressBook + ".json"), list);
			System.out.println("File is saved");
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JarException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saveAs() {
		System.out.println("Enter file name you want to save");
		String file = utility.read_String();
		save(file);
		System.out.println("Your file is saved");

	}

	@Override
	public List<Person> edit() {

		System.out.println("Enter the userName You want to edit");
		String name = utility.read_String();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFirstName().equalsIgnoreCase(name)) {
				int j = 0;
				System.out.println("Match");
				while (j == 0) {
					System.out.println("Press  1   to edit adress/t/t  Press 2 to edit Phone no");
					int choice = utility.read_Integer();

					switch (choice) {

					case 1:
						System.out.println("Enter the State to change");
						person.adress.setState(utility.read_String());

						System.out.println("Enter the city to change");
						person.adress.setCity(utility.read_String());

						System.out.println("Enter the zip to change");
						person.adress.setZip(utility.read_Integer());
						System.out.println("New Adress is updated");
						break;

					case 2:
						System.out.println("Enter the phone no to change");
						person.setPhoneNo(utility.read_Integer());
						System.out.println("Phone no is changed");
						break;
					default:
						System.out.println("Please try next time");
						j = 1;
						break;

					}

				}
			}

		}
		return list;
	}

}
