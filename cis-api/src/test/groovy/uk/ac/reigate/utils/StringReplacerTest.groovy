package uk.ac.reigate.utils

import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.helpers.TestDataHelper

import static org.mockito.Mockito.*

class StringReplacerTest {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void testReplace() {
        String expecting = 'Testing'
        
        String testText = '<test>'
        String actual =  StringReplacer.replace(testText, "<test>", "Testing")
        
        Assert.assertEquals(expecting, actual)
    }
    
    @Test
    public void testReplaceStudentWithNullText() {
        Student student = TestDataHelper.createStudent()
        String testText = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("A text value need to be supplied for text replacement to work.")
        String actual =  StringReplacer.replaceForStudent(testText, student)
    }
    
    @Test
    public void testReplaceStudentWithNullStudent() {
        Student student = null
        String testText = "Test"
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("A student object need to be supplied for text replacement to work.")
        String actual =  StringReplacer.replaceForStudent(testText, student)
    }
    
    @Test
    public void testReplaceStudentWithFirstOrPreferredName() {
        Student student = TestDataHelper.createStudent()
        String expecting = 'Test ' + student.person.firstOrPreferred()
        
        String testText = 'Test <Student>'
        String actual =  StringReplacer.replaceForStudent(testText, student)
        
        Assert.assertEquals(expecting, actual)
    }
    
    @Test
    public void testReplaceStudentGenderPrefixes() {
        Student student = TestDataHelper.createStudent()
        Person person = student.person
        String expecting = "He/She: $person.gender.heShe, His/Her: $person.gender.hisHer, Him/Her: $person.gender.himHer"
        
        String testText = 'He/She: <heShe>, His/Her: <hisHer>, Him/Her: <himHer>'
        String actual =  StringReplacer.replaceForStudent(testText, student)
        
        Assert.assertEquals(expecting, actual)
    }
    
    @Test
    public void testReplacePersonWithNullText() {
        Person person = TestDataHelper.createPerson()
        String testText = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("A text value need to be supplied for text replacement to work.")
        String actual =  StringReplacer.replaceForPerson(testText, person)
    }
    
    @Test
    public void testReplacePersonWithNullPerson() {
        Person person = null
        String testText = "Test"
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("A person object need to be supplied for text replacement to work.")
        String actual =  StringReplacer.replaceForPerson(testText, person)
    }
    
    @Test
    public void testReplacePersonWithFirstOrPreferredName() {
        Person person = TestDataHelper.createPerson()
        String expecting = 'Test ' + person.firstOrPreferred()
        
        String testText = 'Test <Person>'
        String actual =  StringReplacer.replaceForPerson(testText, person)
        
        Assert.assertEquals(expecting, actual)
    }
    
    @Test
    public void testReplacePersonGenderPrefixes() {
        Person person = TestDataHelper.createPerson()
        String expecting = "He/She: $person.gender.heShe, His/Her: $person.gender.hisHer, Him/Her: $person.gender.himHer"
        
        String testText = 'He/She: <heShe>, His/Her: <hisHer>, Him/Her: <himHer>'
        String actual =  StringReplacer.replaceForPerson(testText, person)
        
        Assert.assertEquals(expecting, actual)
    }
}
