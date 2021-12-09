package uk.ac.reigate.utils

import java.util.regex.Pattern

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.exceptions.InvalidDataException

/**
 * This is a helper class that can be used to help replace various placeholder text from a
 * string with the required replacement text. This can be a basic text replacement or 
 * replacements based on various data objects.   
 * 
 * @author Michael Horgan
 *
 */
class StringReplacer {
    
    /**
     * This method is used to replace a given placeholder within the supplied text with the replacement 
     * string provided.
     * 
     * @param text the String that will have text replacements performed on
     * @param placeholder the String that represents the placeholder to be found
     * @param replacement the String to replace the placeholder text with
     * @return the new string 
     */
    public static String replace(String text, String placeholder, String replacement) {
        return text.replaceAll(Pattern.quote(placeholder), replacement)
    }
    
    /**
     * This method is used to replace various place holder text with data from the student record.
     * <br><br>
     * Place holders that are replaced: 
     * <ul>
     * <li>Student - replaced with the students first or preferred name</li>
     * </ul>
     * Note: this also performs all the replacements from the StringReplacer.replaceForPerson method
     * 
     * @param text the text to scan for replacements
     * @param student the student record to use for replacement text
     * @return the string with replacements made
     * @see #replaceForPerson
     * 
     */
    public static String replaceForStudent(String text, Student student) {
        if (text == null) {
            throw new InvalidDataException("A text value need to be supplied for text replacement to work.")
        }
        if (student == null) {
            throw new InvalidDataException("A student object need to be supplied for text replacement to work.")
        }
        String output = text
        output = replaceForPerson(output, student.person)
        output = replace(output, "[Student]", student.person.firstOrPreferred())
        output = replace(output, "<Student>", student.person.firstOrPreferred())
        return output
    }
    
    /**
     * This methods is used to replace various place holder text with data from the person record.
     * <br><br>
     * Place holders that are replaced: 
     * <ul>
     * <li>heshe - replaced with the gender heShe value</li>
     * <li>hisher - replaced with the gender hisHer value</li>
     * <li>himher - replaced with the gender himHer value</li>
     * <li>Person - replaced with the persons first or preferred name</li>
     * </ul> 
     *     
     * @param text the text to scan for replacements
     * @param person the person record to use for replacement text
     * @return the string with replacements made
     */
    public static String replaceForPerson(String text, Person person) {
        if (text == null) {
            throw new InvalidDataException("A text value need to be supplied for text replacement to work.")
        }
        if (person == null) {
            throw new InvalidDataException("A person object need to be supplied for text replacement to work.")
        }
        String output = text
        if (person.gender != null) {
            output = replace(output, "[heshe]", person.gender.heShe)
            output = replace(output, "[hisher]", person.gender.hisHer)
            output = replace(output, "[himher]", person.gender.himHer)
            output = replace(output, "[heShe]", person.gender.heShe)
            output = replace(output, "[hisHer]", person.gender.hisHer)
            output = replace(output, "[himHer]", person.gender.himHer)
            output = replace(output, "<heshe>", person.gender.heShe)
            output = replace(output, "<hisher>", person.gender.hisHer)
            output = replace(output, "<himher>", person.gender.himHer)
            output = replace(output, "<heShe>", person.gender.heShe)
            output = replace(output, "<hisHer>", person.gender.hisHer)
            output = replace(output, "<himHer>", person.gender.himHer)
        }
        output = replace(output, "[Person]", person.firstOrPreferred())
        output = replace(output, "<Person>", person.firstOrPreferred())
        return output
    }
}
