package uk.ac.reigate.dto.errorhandling;

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

@ToString
@EqualsAndHashCode
public class ErrorDto {
    
    @ApiModelProperty(value = "The error code.")
    @JsonProperty("code")
    Integer code = null;
    
    @ApiModelProperty(value = "The error message.")
    @JsonProperty("message")
    String message = null;
    
    @ApiModelProperty(value = "")
    @JsonProperty("fields")
    String fields = null;
    
    @ApiModelProperty(value = "The details of the exception.")
    @JsonProperty("details")
    String details = null;
    
    /**
     * NoArgs constructor
     */
    ErrorDto() {}
}
