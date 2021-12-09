package uk.ac.reigate.model

import uk.ac.reigate.domain.academic.StudentYear;

class StudentWarning {
    
    Integer studentId;
    
    Integer yearId;
    
    Integer attendanceMonitoringId;
    
    Integer punctualityMonitoringId;
    
    StudentWarning() {}
    
    StudentWarning(Integer studentId, Integer yearId, Integer attendanceMonitoringId, Integer punctualityMonitoringId) {
        this.studentId = studentId;
        this.yearId = yearId;
        this.attendanceMonitoringId = attendanceMonitoringId;
        this.punctualityMonitoringId = punctualityMonitoringId;
    }
}
