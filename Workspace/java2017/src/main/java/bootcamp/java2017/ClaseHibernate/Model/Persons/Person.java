package bootcamp.java2017.ClaseHibernate.Model.Persons;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	
	public Person(String firstName, String lastName,  LocalDate dateOfBirth){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
