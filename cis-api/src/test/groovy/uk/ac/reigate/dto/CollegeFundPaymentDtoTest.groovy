package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.admissions.CollegeFundPayment
import uk.ac.reigate.exceptions.InvalidDataException


public class CollegeFundPaymentDtoTest {
    
    private CollegeFundPayment collegeFundPayment1
    
    private CollegeFundPayment collegeFundPayment2
    
    private CollegeFundPayment collegeFundPayment3
    
    private List<CollegeFundPayment> collegeFundPayments
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Student createStudent2() {
        Student student = new Student()
        student.id = 2
        return student
    }
    
    @Before
    public void setup() {
        collegeFundPayment1 = new CollegeFundPayment(
                id: 1,
                student: createStudent(),
                paymentDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                amount: 2.1f,
                payee: 'vinaya',
                giftAid: true,
                cash: true,
                chequeDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        collegeFundPayment2 = new CollegeFundPayment(
                id: 2,
                student: createStudent2(),
                paymentDate: new SimpleDateFormat("yyyy/MM/dd").parse('2014/07/09'),
                amount: 2.1f,
                payee: 'Mich',
                giftAid: true,
                cash: true,
                chequeDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/07/09')
                );
        collegeFundPayment3 = new CollegeFundPayment(
                id: 3,
                student: null,
                paymentDate: new SimpleDateFormat("yyyy/MM/dd").parse('2014/07/09'),
                amount: 2.1f,
                payee: 'Mich',
                giftAid: true,
                cash: true,
                chequeDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/07/09')
                );
        collegeFundPayments = Arrays.asList(collegeFundPayment1, collegeFundPayment2);
    }
    
    @Test
    void testConstructor_collegeFundPayment() {
        CollegeFundPaymentDto collegeFundPaymentTest = new CollegeFundPaymentDto( collegeFundPayment1 )
        assertEquals( collegeFundPaymentTest.id, collegeFundPayment1.id );
        assertEquals( collegeFundPaymentTest.studentId, collegeFundPayment1.student.id);
        assertEquals( collegeFundPaymentTest.paymentDate, collegeFundPayment1.paymentDate);
        assertEquals( collegeFundPaymentTest.amount, collegeFundPayment1.amount, 2.1f);
        assertEquals( collegeFundPaymentTest.payee, collegeFundPayment1.payee);
        assertEquals( collegeFundPaymentTest.giftAid, collegeFundPayment1.giftAid);
        assertEquals( collegeFundPaymentTest.cash, collegeFundPayment1.cash);
        assertEquals( collegeFundPaymentTest.chequeDate, collegeFundPayment1.chequeDate);
    }
    
    @Test
    void testConstructor_NullStudent() {
        CollegeFundPaymentDto collegeFundPaymentTest = new CollegeFundPaymentDto( collegeFundPayment3 )
        assertEquals( collegeFundPaymentTest.id, collegeFundPayment3.id );
        assertEquals( collegeFundPaymentTest.studentId, collegeFundPayment3.student);
        assertEquals( collegeFundPaymentTest.paymentDate, collegeFundPayment3.paymentDate);
        assertEquals( collegeFundPaymentTest.amount, collegeFundPayment3.amount, 2.1f);
        assertEquals( collegeFundPaymentTest.payee, collegeFundPayment3.payee);
        assertEquals( collegeFundPaymentTest.giftAid, collegeFundPayment3.giftAid);
        assertEquals( collegeFundPaymentTest.cash, collegeFundPayment3.cash);
        assertEquals( collegeFundPaymentTest.chequeDate, collegeFundPayment3.chequeDate);
    }
    
    @Test
    public void testConstructor_NullCollegeFundPayment() {
        CollegeFundPayment collegeFundPayment = null
        CollegeFundPaymentDto collegeFundPaymentDto = new CollegeFundPaymentDto(collegeFundPayment)
        assertEquals( collegeFundPayment, null);
    }
    
    @Test
    public void testMapFromCollegeFundPaymentEntity(){
        CollegeFundPaymentDto collegeFundPaymentTest = CollegeFundPaymentDto.mapFromEntity( collegeFundPayment1 )
        assertEquals( collegeFundPaymentTest.id, collegeFundPayment1.id );
        assertEquals( collegeFundPaymentTest.studentId, collegeFundPayment1.student.id);
        assertEquals( collegeFundPaymentTest.paymentDate, collegeFundPayment1.paymentDate);
        assertEquals( collegeFundPaymentTest.amount, collegeFundPayment1.amount, 2.1f);
        assertEquals( collegeFundPaymentTest.payee, collegeFundPayment1.payee);
        assertEquals( collegeFundPaymentTest.giftAid, collegeFundPayment1.giftAid);
        assertEquals( collegeFundPaymentTest.cash, collegeFundPayment1.cash);
    }
    
    @Test
    public void testMapFromCollegeFundPaymentsEntities(){
        List<CollegeFundPaymentDto> collegeFundPaymentsDtoTest = CollegeFundPaymentDto.mapFromList( this.collegeFundPayments )
        assertEquals( collegeFundPaymentsDtoTest[0].id, collegeFundPayment1.id );
        assertEquals( collegeFundPaymentsDtoTest[0].studentId, collegeFundPayment1.student.id);
        assertEquals( collegeFundPaymentsDtoTest[0].paymentDate, collegeFundPayment1.paymentDate);
        assertEquals( collegeFundPaymentsDtoTest[0].amount, collegeFundPayment1.amount, 2.1f);
        assertEquals( collegeFundPaymentsDtoTest[0].payee, collegeFundPayment1.payee);
        assertEquals( collegeFundPaymentsDtoTest[0].giftAid, collegeFundPayment1.giftAid);
        assertEquals( collegeFundPaymentsDtoTest[0].cash, collegeFundPayment1.cash);
        assertEquals( collegeFundPaymentsDtoTest[0].chequeDate, collegeFundPayment1.chequeDate);
        assertEquals( collegeFundPaymentsDtoTest[1].id, collegeFundPayment2.id );
        assertEquals( collegeFundPaymentsDtoTest[1].studentId, collegeFundPayment2.student.id);
        assertEquals( collegeFundPaymentsDtoTest[1].paymentDate, collegeFundPayment2.paymentDate);
        assertEquals( collegeFundPaymentsDtoTest[1].amount, collegeFundPayment2.amount, 2.1f);
        assertEquals( collegeFundPaymentsDtoTest[1].payee, collegeFundPayment2.payee);
        assertEquals( collegeFundPaymentsDtoTest[1].giftAid, collegeFundPayment2.giftAid);
        assertEquals( collegeFundPaymentsDtoTest[1].cash, collegeFundPayment2.cash);
        assertEquals( collegeFundPaymentsDtoTest[1].chequeDate, collegeFundPayment2.chequeDate);
    }
    
    @Test
    public void testEquals_Same() {
        CollegeFundPaymentDto collegeFundPaymentDto1 = new CollegeFundPaymentDto(collegeFundPayment1)
        CollegeFundPaymentDto collegeFundPaymentDto2 = new CollegeFundPaymentDto(collegeFundPayment1)
        assertEquals(collegeFundPaymentDto1, collegeFundPaymentDto2)
    }
    
    @Test
    public void testEquals_Different() {
        CollegeFundPaymentDto collegeFundPaymentDto1 = new CollegeFundPaymentDto(collegeFundPayment1)
        CollegeFundPaymentDto collegeFundPaymentDto2 = new CollegeFundPaymentDto(collegeFundPayment2)
        assertNotEquals(collegeFundPaymentDto1, collegeFundPaymentDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        CollegeFundPaymentDto collegeFundPaymentDto1 = new CollegeFundPaymentDto(collegeFundPayment1)
        CollegeFundPaymentDto collegeFundPaymentDto2 = new CollegeFundPaymentDto(collegeFundPayment1)
        assertEquals(collegeFundPaymentDto1.hashCode(), collegeFundPaymentDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        CollegeFundPaymentDto collegeFundPaymentDto1 = new CollegeFundPaymentDto(collegeFundPayment1)
        CollegeFundPaymentDto collegeFundPaymentDto2 = new CollegeFundPaymentDto(collegeFundPayment2)
        assertNotEquals(collegeFundPaymentDto1.hashCode(), collegeFundPaymentDto2.hashCode())
    }
}
