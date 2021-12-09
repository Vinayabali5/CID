package uk.ac.reigate.dto.lookup;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.lookup.VolunteeringExperience

public class VolunteeringExperienceDtoTest {
    
    private VolunteeringExperience volunteeringExperience1
    
    private VolunteeringExperience volunteeringExperience2
    
    private List<VolunteeringExperience> volunteeringExperiences
    
    @Before
    public void setup() {
        volunteeringExperience1 = new VolunteeringExperience(
                id: 1,
                code:'Int',
                description:'Internal VolunteeringExperience'
                );
        volunteeringExperience2 = new VolunteeringExperience(
                id: 2,
                code:'Ext',
                description:'External VolunteeringExperience'
                );
        volunteeringExperiences = Arrays.asList(volunteeringExperience1, volunteeringExperience2);
    }
    
    @Test
    public void testMapFromVolunteeringExperienceEntity(){
        VolunteeringExperienceDto volunteeringExperienceTest = VolunteeringExperienceDto.mapFromEntity( volunteeringExperience1 )
        assertEquals( volunteeringExperienceTest.id, volunteeringExperience1.id );
        assertEquals( volunteeringExperienceTest.code, volunteeringExperience1.code);
        assertEquals( volunteeringExperienceTest.description, volunteeringExperience1.description);
    }
    
    @Test
    public void testMapFromVolunteeringExperiencesEntities(){
        List<VolunteeringExperienceDto> volunteeringExperienceDtoTest = VolunteeringExperienceDto.mapFromList( volunteeringExperiences )
        assertEquals( volunteeringExperienceDtoTest[0].id, volunteeringExperience1.id );
        assertEquals( volunteeringExperienceDtoTest[0].code, volunteeringExperience1.code);
        assertEquals( volunteeringExperienceDtoTest[0].description, volunteeringExperience1.description);
        assertEquals( volunteeringExperienceDtoTest[1].id, volunteeringExperience2.id );
        assertEquals( volunteeringExperienceDtoTest[1].code, volunteeringExperience2.code);
        assertEquals( volunteeringExperienceDtoTest[1].description, volunteeringExperience2.description);
    }
    
    @Test
    public void testEquals_Same() {
        VolunteeringExperienceDto volunteeringExperienceDto1 = new VolunteeringExperienceDto(volunteeringExperience1)
        VolunteeringExperienceDto volunteeringExperienceDto2 = new VolunteeringExperienceDto(volunteeringExperience1)
        assertEquals(volunteeringExperienceDto1, volunteeringExperienceDto2)
    }
    
    @Test
    public void testEquals_Different() {
        VolunteeringExperienceDto volunteeringExperienceDto1 = new VolunteeringExperienceDto(volunteeringExperience1)
        VolunteeringExperienceDto volunteeringExperienceDto2 = new VolunteeringExperienceDto(volunteeringExperience2)
        assertNotEquals(volunteeringExperienceDto1, volunteeringExperienceDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        VolunteeringExperienceDto volunteeringExperienceDto1 = new VolunteeringExperienceDto(volunteeringExperience1)
        VolunteeringExperienceDto volunteeringExperienceDto2 = new VolunteeringExperienceDto(volunteeringExperience1)
        assertEquals(volunteeringExperienceDto1.hashCode(), volunteeringExperienceDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        VolunteeringExperienceDto volunteeringExperienceDto1 = new VolunteeringExperienceDto(volunteeringExperience1)
        VolunteeringExperienceDto volunteeringExperienceDto2 = new VolunteeringExperienceDto(volunteeringExperience2)
        assertNotEquals(volunteeringExperienceDto1.hashCode(), volunteeringExperienceDto2.hashCode())
    }
    
    @Test
    public void testConstructor_VolunteeringExperience() {
        VolunteeringExperienceDto volunteeringExperienceDto = new VolunteeringExperienceDto(volunteeringExperience1)
        assertEquals( volunteeringExperienceDto.code, volunteeringExperience1.code )
        assertEquals( volunteeringExperienceDto.description, volunteeringExperience1.description )
    }
}
