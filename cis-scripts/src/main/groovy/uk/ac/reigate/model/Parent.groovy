package uk.ac.reigate.model

/**
 * The Parent object is a help model object that is used for the creation of Contact for Students in the School Import routine
 * 
 * @author Michael Horgan
 *
 */
class Parent {
	String title

	String firstName

	String surname

	Parent() {}

	Parent(String title, String firstName, String surname) {
		this.title = title
		this.firstName = firstName
		this.surname = surname
	}

	String toString() {
		String out
		out = title != null ? title + ' ' : ''
		out+= firstName != null ? firstName + ' ' : ''
		out+= surname != null ? surname + ' ' : ''
		return out.trim()
	}
}

