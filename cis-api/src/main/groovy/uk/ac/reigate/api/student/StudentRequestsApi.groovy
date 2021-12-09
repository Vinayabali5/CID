package uk.ac.reigate.api.student

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import uk.ac.reigate.domain.admissions.Request
import uk.ac.reigate.dto.RequestDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.RequestService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/students", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/students", description = "the requests API")
class StudentRequestsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRequestsApi.class);
    
    @Autowired
    private final RequestService requestService;
    
    /**
     * The getRequestByStudentId method is used to retrieve a list of requests by studentId and yearId. If there is not yearId provided, it lists the full set of requests else it lists requests for the given yearId
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves s list of a Requests identified by the StudentId and academicYearId", notes = "A GET request to the Request instance endpoint will retrieve list of Request entity as identified by the studentId provided in the URI.", response = RequestDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns List of the Request as identified by the Student id and Year Id"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found.")
    ])
    @RequestMapping(value = "/{studentId}/requests", produces = ["application/json"], method = RequestMethod.GET)
    ResponseEntity<List<RequestDto>> getRequestByStudentId(
            @ApiParam(value = "The student ID of the Request to retrieve", required = true) @PathVariable("studentId") Integer studentId,
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** StudentRequestsApi - getRequestByStudentId");
        List<Request> requestList
        if(!yearId){
            requestList = requestService.findByStudentId(studentId)
        }else{
            requestList = requestService.findByStudentIdYearId(studentId, yearId)
        }
        if (requestList.size() != 0) {
            return new ResponseEntity<List<RequestDto>>(RequestDto.mapFromRequestsEntities(requestList), HttpStatus.OK)
        }else
            throw new NotFoundException();
    }
}
