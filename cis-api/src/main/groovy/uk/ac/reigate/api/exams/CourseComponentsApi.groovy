package uk.ac.reigate.api.exams

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

import uk.ac.reigate.domain.exams.CourseComponent
import uk.ac.reigate.dto.exams.CourseComponentDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.exams.CourseComponentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/course-components", produces = [APPLICATION_JSON_VALUE])
@Api(value = "/CourseComponentsApi", description = "The Exam CourseComponents Resource API")
public class CourseComponentsApi {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(CourseComponentsApi.class)
    
    @Autowired
    CourseComponentService courseComponentService
    
    /**
     * Default No Args constructor
     */
    CourseComponentsApi() {}
    
    /**
     * Default Autowired constructor
     */
    CourseComponentsApi(CourseComponentService courseComponentService) {
        this.courseComponentService = courseComponentService;
    }
    
    /**
     * The courseComponentsGet method is used to retrieve a full list of all the CourseComponentsDto objects
     * 
     * @return A ResponseEntity with the corresponding list of CourseComponentDto objects
     * @throws NotFoundException if nothing is found then the NotFoundException is thrown
     */
    @ApiOperation(value = "Collection of CourseComponents entities", notes = "A GET request to the CourseComponents endpoint returns an array of all the courseComponents in the system",
    response = CourseComponentDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of courseComponents")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<CourseComponentDto>> getAll() throws NotFoundException {
        LOGGER.info("** CourseComponentApi - courseComponentsGet");
        List<CourseComponent> courseComponents = courseComponentService.findAll();
        return new ResponseEntity<List<CourseComponentDto>>(CourseComponentDto.mapFromList(courseComponents), HttpStatus.OK);
    }
    
    /**
     * The courseComponentCourseIdOptionIdComponentIdGet method is used to retrieve an instance of a CourseComponentDto object 
     * as identified by the courseId, examOptionId and examComponentId provided
     * 
     * @param courseId The courseId composite ID of the CourseComponent object to retrieve
     * @param examOptionId the examOptionId composite ID of the CourseComponent object to retrieve.
     * @param examComponentId the examComponentId composite Id of the CourseComponent object to retrieve
     * @return A ResponseEntity with the corresponding CourseComponentDto object
     * @throws NotFoundException if nothing is found then the NotFoundException is thrown
     */
    @ApiOperation(value = "Retrieves an individual instance of a CourseComponent identified by the courseId, examOptionId and examComponentId",
    notes = "A GET request to the CourseComponents endpoint will retrieve an instance of a CourseComponent entity as identified by the courseId, examOptionId and examComponentId provided in the URI.",
    response = CourseComponentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the CourseComponent as identified by the courseId, examOptionId and examComponentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified composite Id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{courseId}/{examOptionId}/{examComponentId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<CourseComponentDto> getByIds(
            @ApiParam(value = "The courseId element of the composite Id of the CourseComponent to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The examOptionId element of the composite Id of the CourseComponent to retrieve", required = true)
            @PathVariable("examOptionId") Integer examOptionId,
            @ApiParam(value = "The examComponentId element of the composite Id of the CourseComponent to retrieve", required = true)
            @PathVariable("examComponentId") Integer examComponentId
    ) throws NotFoundException {
        LOGGER.info("** CourseComponentApi - getByIds");
        CourseComponent courseComponent = courseComponentService.findCourseComponent(courseId, examOptionId, examComponentId);
        if (courseComponent == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<CourseComponentDto>(CourseComponentDto.mapFromEntity(courseComponent), HttpStatus.OK);
    }
    
    /**
     * The courseComponentDelete method is used to delete an instance of a CourseComponent object from the supplied CourseComponentDto entity
     * 
     * @param courseComponent The courseComponentDto from which to delete the CourseComponent object
     * @return A ResponseEntity with an OK object
     * @throws NotFoundException
     */
    @ApiOperation(value = "Deletes a CourseComponent entity",
    notes = "A DELETE request to the CourseComponent endpoint with a CourseComponent object in the request body will delete a CourseComponent entity in the database")
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns an OK object stating that the CourseComponent entity has just been deleted")
    ])
    @RequestMapping(value = "/{courseId}/{examOptionId}/{examComponentId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(
            @ApiParam(value = "The courseId element of the composite Id of the CourseComponent to retrieve", required = true)
            @PathVariable("courseId") Integer courseId,
            @ApiParam(value = "The examOptionId element of the composite Id of the CourseComponent to retrieve", required = true)
            @PathVariable("examOptionId") Integer examOptionId,
            @ApiParam(value = "The examComponentId element of the composite Id of the CourseComponent to retrieve", required = true)
            @PathVariable("examComponentId") Integer examComponentId
    ) throws NotFoundException {
        LOGGER.info("** CourseComponentApi - courseComponentDelete");
        Boolean deleted = courseComponentService.deleteByIds(courseId, examOptionId, examComponentId)
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
