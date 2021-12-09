package uk.ac.reigate.utils

import java.sql.CallableStatement
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

import org.hibernate.HibernateException
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator

/**
 * This class is used to generate the student_id field for a new Student object. This generator uses a stored function on the SQL server
 * to generate an academic year specific student ID.
 * 
 * @author Michael Horgan
 *
 */
class StudentIdGenerator implements IdentifierGenerator {
    
    private static final String QUERY_CALL = 'SELECT Data.GetNextStudentId(Data.GetNextAcademicYearId())'
    
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Integer result = null;
        try {
            Connection connection = session.connection();
            CallableStatement callableStmt = connection. prepareCall(QUERY_CALL);
            ResultSet rs = callableStmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1)
            }
            //connection.close();
        } catch (SQLException sqlException) {
            throw new HibernateException(sqlException);
        }
        return result;
    }
}
