package uk.ac.reigate.dto.exams.basedata;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.OptionComponent
import uk.ac.reigate.domain.exams.basedata.ExamComponent

public class OptionComponentDtoTest {
    
    private OptionComponent optionComponent1
    
    private OptionComponent optionComponent2
    
    private List<OptionComponent> optionComponentList
    
    private ExamOption examOption
    
    @Before
    public void setup() {
        this.optionComponent1 = new OptionComponent(
                examOption : new ExamOption(id: 1),
                examComponent : new ExamComponent(id: 1)
                );
        this.optionComponent2 = new OptionComponent(
                examOption : new ExamOption(id: 4),
                examComponent : new ExamComponent(id: 4)
                );
        this.optionComponentList = Arrays.asList(this.optionComponent1, this.optionComponent2);
    }
    
    @Test
    void testconstructor_optionComponentDto() {
        OptionComponentDto optionComponentDto = new OptionComponentDto(optionComponent1)
        assertEquals( optionComponentDto.examOptionId, optionComponent1.examOption.id)
        assertEquals( optionComponentDto.examComponentId, optionComponent1.examComponent.id)
    }
    
    @Test
    void testConstructor_optionComponent() {
        ExamOption examOption = new ExamOption(id: 1)
        ExamComponent examComponent = new ExamComponent(id: 1)
        OptionComponentDto optionComponentDto = new OptionComponentDto( examOption, examComponent )
        assertEquals( optionComponentDto.examOptionId, examOption.id);
        assertEquals( optionComponentDto.examComponentId, examComponent.id);
    }
    
    @Test
    public void testMapFromOptionComponentEntity() {
        OptionComponentDto optionComponentDto = OptionComponentDto.mapFromEntity( optionComponent1 );
        assertEquals( optionComponentDto.examOptionId, optionComponent1.examOption.id);
        assertEquals( optionComponentDto.examComponentId, optionComponent1.examComponent.id);
    }
    
    @Test
    public void testMapFromOptionComponentEntities(){
        List<OptionComponentDto> optionComponentDtoList = OptionComponentDto.mapFromList( this.optionComponentList )
        assertEquals( optionComponentDtoList[0].examOptionId, optionComponent1.examOption.id);
        assertEquals( optionComponentDtoList[0].examComponentId, optionComponent1.examComponent.id);
        assertEquals( optionComponentDtoList[1].examOptionId, optionComponent2.examOption.id);
        assertEquals( optionComponentDtoList[1].examComponentId, optionComponent2.examComponent.id);
    }
}
