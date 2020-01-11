package com.bridgelabz.adressbook;

import java.util.List;

public interface AdressBook {
 public List<Person> add();
 public List<Person> edit();
 public void remove();
 public void sortByName();
 public void sortByZip();
 public void printAll();
//List<Person> edit(List<Person> list);
}
