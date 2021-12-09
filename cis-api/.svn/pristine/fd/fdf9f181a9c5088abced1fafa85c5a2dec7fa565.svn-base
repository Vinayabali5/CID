package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.admissions.CollegeFundPayment
import uk.ac.reigate.dto.CollegeFundPaymentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.CollegeFundPaymentRepository
import uk.ac.reigate.services.student.StudentService

@Service
@RequiredArgsConstructor
class CollegeFundPaymentService implements ICoreDataService<CollegeFundPayment, Integer>, IDtoCreateUpdateService<CollegeFundPaymentDto, CollegeFundPayment>{
    
    @Autowired
    CollegeFundPaymentRepository collegeFundPaymentRepository
    
    @Autowired
    StudentService studentService;
    
    /**
     * Default NoArgs constructor
     */
    CollegeFundPaymentService() {}
    
    /**
     * Autowired Constructor
     *
     * @param collegeFundPaymentRepository
     */
    CollegeFundPaymentService(CollegeFundPaymentRepository collegeFundPaymentRepository, StudentService studentService) {
        super();
        this.collegeFundPaymentRepository = collegeFundPaymentRepository;
        this.studentService = studentService;
    }
    
    /**
     * Find an individual collegeFundPayment using the collegeFundPayments ID fields
     *
     * @param id the ID fields to search for
     * @return the CollegeFundPayment object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    CollegeFundPayment findById(Integer id) {
        return collegeFundPaymentRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all collegeFundPayments
     *
     * @return a SearchResult set with the list of CollegeFundPayments
     */
    @Override
    @Transactional(readOnly = true)
    List<CollegeFundPayment> findAll() {
        return collegeFundPaymentRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete CollegeFundPayment object in the database
     *
     * @param collegeFundPayment the new CollegeFundPayment object to be saved
     * @return the saved version of the CollegeFundPayment object
     */
    @Override
    @Transactional
    public CollegeFundPayment save(CollegeFundPayment collegeFundPayment) {
        return collegeFundPaymentRepository.save(collegeFundPayment)
    }
    
    /**
     * Saves a list of CollegeFundPayment objects to the database
     *
     * @param collegeFundPayments a list of CollegeFundPayments to be saved to the database
     * @return the list of save CollegeFundPayment objects
     */
    @Transactional
    public List<CollegeFundPayment> saveCollegeFundPayments(List<CollegeFundPayment> collegeFundPayments) {
        return collegeFundPayments.collect { collegeFundPayment -> save(collegeFundPayment)};
    }
    
    /**
     * This service method is used to retrieve a list of collegeFundPayments for a specified student based on the provided studentId
     * 
     * @param studentId the studentId to use as a filter
     * @return a filtered list of collegeFundPayment for the specified student
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    List<CollegeFundPayment> findCollegeFundPaymentsByStudentId(Integer studentId) {
        return collegeFundPaymentRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This service method is used to create a CollegeFundPayment object in the database from a partial or complete CollegeFundPayment object.
     *
     * @param collegeFundPayment the partial or complete CollegeFundPayment object to be saved
     * @return the saved version of the CollegeFundPayment object
     */
    @Transactional
    public CollegeFundPayment createFromDto(CollegeFundPaymentDto collegeFundPaymentDto) {
        CollegeFundPayment collegeFundPayment = new CollegeFundPayment()
        if (collegeFundPaymentDto.studentId != null) {
            collegeFundPayment.student= studentService.findById(collegeFundPaymentDto.studentId)
        }
        collegeFundPayment.paymentDate = collegeFundPaymentDto.paymentDate;
        collegeFundPayment.amount = collegeFundPaymentDto.amount;
        collegeFundPayment.payee = collegeFundPaymentDto.payee;
        collegeFundPayment.giftAid = collegeFundPaymentDto.giftAid;
        collegeFundPayment.cash = collegeFundPaymentDto.cash;
        collegeFundPayment.chequeDate = collegeFundPaymentDto.chequeDate;
        return save(collegeFundPayment)
    }
    
    /**
     * This service method is used to update a CollegeFundPayment object in the database from a partial or complete CollegeFundPayment object.
     *
     * @param collegeFundPayment the partial or complete CollegeFundPayment object to be saved
     * @return the saved version of the CollegeFundPayment object
     */
    @Transactional
    public CollegeFundPayment updateFromDto(CollegeFundPaymentDto collegeFundPaymentDto) {
        if(collegeFundPaymentDto.id == null) {
            throw new InvalidDataException("CollegeFundPayment ID should not be null when updating")
        }
        CollegeFundPayment collegeFundPayment = findById(collegeFundPaymentDto.id)
        if (collegeFundPaymentDto.studentId != null) {
            collegeFundPayment.student = studentService.findById(collegeFundPaymentDto.studentId)
        }
        collegeFundPayment.paymentDate = collegeFundPaymentDto.paymentDate;
        collegeFundPayment.amount = collegeFundPaymentDto.amount;
        collegeFundPayment.payee = collegeFundPaymentDto.payee;
        collegeFundPayment.giftAid = collegeFundPaymentDto.giftAid;
        collegeFundPayment.cash = collegeFundPaymentDto.cash;
        collegeFundPayment.chequeDate = collegeFundPaymentDto.chequeDate;
        return save(collegeFundPayment)
    }
    
    /**
     * @param studentId
     * @return List of CollegeFundPayment of a studentId
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional
    public  List<CollegeFundPayment> getByStudent(Integer studentId){
        return collegeFundPaymentRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This methods throws an InvalidOperationException when called. CollegeFundPayment should not be deleted.
     */
    @Override
    public void delete(CollegeFundPayment obj) {
        throw new InvalidOperationException("CollegeFundPayment should not be deleted.")
    }
}
