package uk.ac.reigate.services.audit

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.audit.ApiAccessLog
import uk.ac.reigate.repositories.audit.ApiAccessLogRepository

@Service
class AuditService {
    
    @Autowired
    ApiAccessLogRepository apiAccessLogRepository
    
    AuditService(ApiAccessLogRepository apiAccessLogRepository) {
        this.apiAccessLogRepository = apiAccessLogRepository
    }
    
    void logApiAccess(String username, String remoteHost, String method, String uri, String params, String content) {
        try {
            apiAccessLogRepository.save(new ApiAccessLog(
                    username: username,
                    remoteHost: remoteHost,
                    method: method,
                    uri: uri,
                    params: params,
                    content: content
                    ))
        } catch (Exception ex) {
            ex.printStackTrace()
        }
    }
}
