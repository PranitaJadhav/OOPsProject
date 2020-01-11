package com.bridgelabz.adressbook;

import java.io.IOException;

public interface AddressBookManager {
	public void create() throws IOException;
	public void save(String file);
	public void saveAs();
	public void readAddress();
	public void read(String existingaddressBook) throws IOException, Exception;
	public void close(String existingaddressBook);

}
