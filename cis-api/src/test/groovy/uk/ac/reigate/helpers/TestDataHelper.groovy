package uk.ac.reigate.helpers

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.Gender

class TestDataHelper {
    
    /**
     * A helper method to create a gender male
     */
    public static Gender createGenderMale() {
        Gender male = new Gender()
        male.code = 'M'
        male.description = 'Male'
        male.heShe = 'he'
        male.hisHer = 'his'
        male.himHer = 'him'
        return male
    }
    
    /**
     * A helper method to create a gender female
     */
    public static Gender createGenderFemale() {
        Gender female = new Gender()
        female.code = 'F'
        female.description = 'Female'
        female.heShe = 'she'
        female.hisHer = 'her'
        female.himHer = 'her'
        return female
    }
    
    /**
     * A helper method to create a gender
     */
    public static Gender createGender() {
        return createGenderMale()
    }
    
    /**
     * A helper method to create a person called John Smith
     */
    public static Person createPersonJohn() {
        Person person = new Person()
        person.firstName = 'John'
        person.surname = 'Smith'
        person.legalSurname = 'Smith'
        person.gender = createGenderMale()
        return person
    }
    
    /**
     * A helper method to create a person called Jane Doe
     */
    public static Person createPersonJane() {
        Person person = new Person()
        person.firstName = 'Jane'
        person.surname = 'Doe'
        person.legalSurname = 'Doe'
        person.gender = createGenderFemale()
        return person
    }
    
    /**
     * A helper method to create a person
     */
    public static Person createPerson() {
        return createPersonJohn()
    }
    
    /**
     * A helper method to create a student called John Smith
     */
    public static Student createStudentJohn() {
        Student student = new Student()
        student.id = 1
        student.person = createPersonJohn()
        return student
    }
    
    /**
     * A helper method to create a student called Jane Doe
     */
    public static Student createStudentJane() {
        Student student = new Student()
        student.id = 2
        student.person = createPersonJane()
        return student
    }
    
    /**
     * A helper method to create a student
     */
    public static createStudent() {
        return createStudentJohn()
    }
}
