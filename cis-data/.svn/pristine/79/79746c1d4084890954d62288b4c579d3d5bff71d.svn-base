package uk.ac.reigate.constraints

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

import uk.ac.reigate.domain.CodedEntity

/**
 * This class is a ConstraintValidator that can be used with the @Constraint anonotation to ensure
 * that the specified CodedEntity has the code fields set to a value. 
 *  
 * @author Michael Horgan
 *
 */
class CodeRequiredConstraint implements ConstraintValidator {
    
    /**
     * This validate that a code field is present on the CodedEntity supplied. 
     */
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        CodedEntity entity = (CodedEntity) value
        return entity.code != null;
    }
}
