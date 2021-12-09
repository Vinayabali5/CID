package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory
import uk.ac.reigate.domain.learning_support.ReferralReason

public class ReferralReasonDtoTest {
    
    private ReferralReason referralReason1
    
    private ReferralReason referralReason2
    
    private ReferralReason referralReason3
    
    private LLDDHealthProblemCategory llddHealthProblemCategory
    
    private List<ReferralReason> referralReasons
    
    @Before
    public void setup() {
        
        this.llddHealthProblemCategory = new LLDDHealthProblemCategory(id: 1, description: 'Test');
        referralReason1 = new ReferralReason(
                id: 1,
                reason:'M',
                llddHealthProblemCategory: llddHealthProblemCategory
                );
        referralReason2 = new ReferralReason(
                id: 2,
                reason:'F',
                llddHealthProblemCategory: llddHealthProblemCategory
                );
        referralReason3 = new ReferralReason(
                id: 2,
                reason:'F',
                llddHealthProblemCategory: null
                );
        referralReasons = Arrays.asList(referralReason1, referralReason2);
    }
    
    ReferralReasonDto generateReferralReasonDto() {
        return generateReferralReason1Dto()
    }
    
    ReferralReasonDto generateReferralReason1Dto() {
        return new ReferralReasonDto(referralReason1.id, referralReason1.reason, referralReason1.llddHealthProblemCategory.id)
    }
    
    ReferralReasonDto generateReferralReason2Dto() {
        return new ReferralReasonDto(referralReason2.id, referralReason2.reason, referralReason2.llddHealthProblemCategory.id)
    }
    
    @Test
    public void testConstructor_NullObject() {
        ReferralReason referralReason = null
        ReferralReasonDto referralReasonTest = ReferralReasonDto.mapFromEntity( referralReason )
        assertEquals( referralReason, null );
    }
    
    @Test
    public void testMapFromReferralReasonEntity(){
        ReferralReasonDto referralReasonTest = ReferralReasonDto.mapFromEntity( referralReason1 )
        assertEquals( referralReasonTest.id, referralReason1.id );
        assertEquals( referralReasonTest.reason, referralReason1.reason);
        assertEquals( referralReasonTest.llddHealthProblemCategoryId, referralReason1.llddHealthProblemCategory.id);
    }
    
    @Test
    public void testMapFromReferralReasonsEntities(){
        List<ReferralReasonDto> referralReasonsDtoTest = ReferralReasonDto.mapFromList( referralReasons )
        assertEquals( referralReasonsDtoTest[0].id, referralReason1.id );
        assertEquals( referralReasonsDtoTest[0].reason, referralReason1.reason);
        assertEquals( referralReasonsDtoTest[0].llddHealthProblemCategoryId, referralReason1.llddHealthProblemCategory.id);
        assertEquals( referralReasonsDtoTest[1].id, referralReason2.id );
        assertEquals( referralReasonsDtoTest[1].reason, referralReason2.reason);
        assertEquals( referralReasonsDtoTest[1].llddHealthProblemCategoryId, referralReason2.llddHealthProblemCategory.id);
    }
    
    @Test
    public void testEquals_Same() {
        ReferralReasonDto referralReasonDto1 = new ReferralReasonDto(referralReason1)
        ReferralReasonDto referralReasonDto2 = new ReferralReasonDto(referralReason1)
        assertEquals(referralReasonDto1, referralReasonDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ReferralReasonDto referralReasonDto1 = new ReferralReasonDto(referralReason1)
        ReferralReasonDto referralReasonDto2 = new ReferralReasonDto(referralReason2)
        assertNotEquals(referralReasonDto1, referralReasonDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ReferralReasonDto referralReasonDto1 = new ReferralReasonDto(referralReason1)
        ReferralReasonDto referralReasonDto2 = new ReferralReasonDto(referralReason1)
        assertEquals(referralReasonDto1.hashCode(), referralReasonDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ReferralReasonDto referralReasonDto1 = new ReferralReasonDto(referralReason1)
        ReferralReasonDto referralReasonDto2 = new ReferralReasonDto(referralReason2)
        assertNotEquals(referralReasonDto1.hashCode(), referralReasonDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullLLDDHealthProblemCategoryDescription() {
        ReferralReasonDto referralReasonDto1 = new ReferralReasonDto(referralReason3)
        assertEquals(referralReasonDto1.llddHealthProblemCategory, referralReasonDto1.get_LLDDHealthProblemCategoryDescription())
    }
    
    @Test
    public void testMethod_Get_LLDDHealthProblemCategoryDescription() {
        ReferralReasonDto referralReasonDto1 = new ReferralReasonDto(referralReason1)
        assertEquals(referralReasonDto1.llddHealthProblemCategory.description, referralReasonDto1.get_LLDDHealthProblemCategoryDescription())
    }
}
