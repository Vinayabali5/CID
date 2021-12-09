package uk.ac.reigate.dto.risk_assessment;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.risk_assessment.RiskLevel

public class RiskLevelDtoTest {
    
    private RiskLevel riskLevel1
    
    private RiskLevel riskLevel2
    
    
    private List<RiskLevel> riskLevels
    
    @Before
    public void setup() {
        riskLevel1 = new RiskLevel(
                id: 1,
                code:'1',
                description:'RiskLevel1',
                priority: 1,
                sendEmail : true,
                sendEmailSafeguarding: false
                
                );
        riskLevel2 = new RiskLevel(
                id: 2,
                code:'2',
                description:'RiskLevel2',
                priority: 1,
                sendEmail : true,
                sendEmailSafeguarding: false
                );
        riskLevels = Arrays.asList(riskLevel1, riskLevel2);
    }
    
    @Test
    public void testConstructor() {
        RiskLevel riskLevel = null
        RiskLevelDto riskLevelDto = new RiskLevelDto(riskLevel)
        assertEquals(riskLevel, null)
    }
    
    @Test
    public void testMapFromRiskLevelEntity(){
        RiskLevelDto riskLevelTest = RiskLevelDto.mapFromEntity( riskLevel1 )
        assertEquals( riskLevelTest.id, riskLevel1.id );
        assertEquals( riskLevelTest.code, riskLevel1.code);
        assertEquals( riskLevelTest.description, riskLevel1.description);
        assertEquals( riskLevelTest.priority, riskLevel1.priority);
        assertEquals( riskLevelTest.sendEmail, riskLevel1.sendEmail);
        assertEquals( riskLevelTest.sendEmailSafeguarding, riskLevel1.sendEmailSafeguarding);
    }
    
    @Test
    public void testMapFromRiskLevelsEntities(){
        List<RiskLevelDto> riskLevelsDtoTest = RiskLevelDto.mapFromList( riskLevels )
        assertEquals( riskLevelsDtoTest[0].id, riskLevel1.id );
        assertEquals( riskLevelsDtoTest[0].code, riskLevel1.code);
        assertEquals( riskLevelsDtoTest[0].description, riskLevel1.description);
        assertEquals( riskLevelsDtoTest[0].priority, riskLevel1.priority);
        assertEquals( riskLevelsDtoTest[0].sendEmail, riskLevel1.sendEmail);
        assertEquals( riskLevelsDtoTest[0].sendEmailSafeguarding, riskLevel1.sendEmailSafeguarding);
        assertEquals( riskLevelsDtoTest[1].id, riskLevel2.id );
        assertEquals( riskLevelsDtoTest[1].code, riskLevel2.code);
        assertEquals( riskLevelsDtoTest[1].description, riskLevel2.description);
        assertEquals( riskLevelsDtoTest[1].priority, riskLevel2.priority);
        assertEquals( riskLevelsDtoTest[1].sendEmail, riskLevel2.sendEmail);
        assertEquals( riskLevelsDtoTest[1].sendEmailSafeguarding, riskLevel2.sendEmailSafeguarding);
    }
    
    @Test
    public void testEquals_Same() {
        RiskLevelDto riskLevelDto1 = new RiskLevelDto(riskLevel1)
        RiskLevelDto riskLevelDto2 = new RiskLevelDto(riskLevel1)
        assertEquals(riskLevelDto1, riskLevelDto2)
    }
    
    @Test
    public void testEquals_Different() {
        RiskLevelDto riskLevelDto1 = new RiskLevelDto(riskLevel1)
        RiskLevelDto riskLevelDto2 = new RiskLevelDto(riskLevel2)
        assertNotEquals(riskLevelDto1, riskLevelDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        RiskLevelDto riskLevelDto1 = new RiskLevelDto(riskLevel1)
        RiskLevelDto riskLevelDto2 = new RiskLevelDto(riskLevel1)
        assertEquals(riskLevelDto1.hashCode(), riskLevelDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        RiskLevelDto riskLevelDto1 = new RiskLevelDto(riskLevel1)
        RiskLevelDto riskLevelDto2 = new RiskLevelDto(riskLevel2)
        assertNotEquals(riskLevelDto1.hashCode(), riskLevelDto2.hashCode())
    }
    
    @Test
    public void testConstructor_RiskLevel() {
        RiskLevelDto riskLevelDto = new RiskLevelDto(riskLevel1)
        assertEquals( riskLevelDto.code, riskLevel1.code )
        assertEquals( riskLevelDto.description, riskLevel1.description )
        assertEquals( riskLevelDto.priority, riskLevel1.priority )
        assertEquals( riskLevelDto.sendEmail, riskLevel1.sendEmail )
    }
}
