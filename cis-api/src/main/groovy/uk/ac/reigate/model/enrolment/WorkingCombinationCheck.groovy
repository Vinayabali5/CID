package uk.ac.reigate.model.enrolment

import javax.validation.constraints.NotEmpty

class WorkingCombinationCheck {
    
    @NotEmpty
    String[] specs
    
    Date date
}
