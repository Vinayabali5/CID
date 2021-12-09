package uk.ac.reigate.domain.audit

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@Table(name="api_access_log",  catalog = "CID", schema = "Audit")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "api_access_log_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
class ApiAccessLog extends BaseEntity {
    
    @Column(name = "access_time")
    Date accessTime
    
    @Column(name = "username")
    String username
    
    @Column(name = "remote_host")
    String remoteHost
    
    @Column(name = "method")
    String method
    
    @Column(name = "uri")
    String uri
    
    @Column(name = "params")
    String params
    
    @Column(name = "content", columnDefinition = "text")
    String content
}
