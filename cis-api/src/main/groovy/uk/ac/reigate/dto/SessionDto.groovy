package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Period
import uk.ac.reigate.domain.register.RegisteredSession;

/**
 *
 * JSON serializable DTO containing Session data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SessionDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Date date;
    
    @JsonProperty
    private Integer periodId;
    
    /**
     * Default No Args constructor
     */
    public SessionDto() {
    }
    
    /**
     * Constructor to create a SessionDto object from a Session object
     *
     * @param session the Session object to use for construction
     */
    SessionDto(RegisteredSession session){
        this.id = session.id;
        this.date = session.date;
        this.periodId = session.period != null ? session.period.id : null;
    }
    
    /**
     * This static method is used to create a SessionDto from a RegisteredSession data object.
     *
     * @param registeredSession the RegisteredSession data object to use for the creation.
     * @return a SessionDto object based on the RegisteredSession data object supplied.
     */
    public static SessionDto mapFromEntity(RegisteredSession session) {
        return new SessionDto(session)
    }
    
    /**
     * This static method is used to create a List of RegisteredSessionDto from a List of RegisteredSession data object.
     *
     * @param registeredSessions the List of RegisteredSession data object to use for the creation.
     * @return a List of SessionDto object based on the List of RegisteredSession data object supplied.
     */
    public static List<SessionDto> mapFromList(List<RegisteredSession> sessions) {
        return sessions.collect { session ->  new SessionDto(session) };
    }
}
