package com.data;

public class Person {
   private String firstName;
   private String lastName;
   
   public Person() {
   
   }
   
   public Person(String fname, String lname) {
	   firstName = fname;
	   lastName = lname;
   }
   
   public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

   
   
}
