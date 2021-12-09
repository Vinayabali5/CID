package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QSchoolReference is a Querydsl query type for SchoolReference
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSchoolReference extends EntityPathBase<SchoolReference> {
    
    private static final long serialVersionUID = 43160089L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QSchoolReference schoolReference = new QSchoolReference("schoolReference");
    
    public final StringPath areasOfNeed = createString("areasOfNeed");
    
    public final NumberPath<Integer> attainmentPotential = createNumber("attainmentPotential", Integer.class);
    
    public final NumberPath<Integer> behaviour = createNumber("behaviour", Integer.class);
    
    public final BooleanPath behaviouralIssues = createBoolean("behaviouralIssues");
    
    public final StringPath behaviouralIssuesComment = createString("behaviouralIssuesComment");
    
    public final DateTimePath<java.util.Date> dateOfLastReport = createDateTime("dateOfLastReport", java.util.Date.class);
    
    public final StringPath detailsOfSupport = createString("detailsOfSupport");
    
    public final NumberPath<Integer> effort = createNumber("effort", Integer.class);
    
    public final BooleanPath ehcp = createBoolean("ehcp");
    
    public final BooleanPath examAccess = createBoolean("examAccess");
    
    public final StringPath examAccessDetails = createString("examAccessDetails");
    
    public final StringPath externalAgencies = createString("externalAgencies");
    
    public final NumberPath<Integer> homeworkCompletion = createNumber("homeworkCompletion", Integer.class);
    
    public final NumberPath<Integer> independence = createNumber("independence", Integer.class);
    
    public final StringPath literacyLevel = createString("literacyLevel");
    
    public final NumberPath<Integer> meetingTargets = createNumber("meetingTargets", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> organisation = createNumber("organisation", Integer.class);
    
    public final BooleanPath recommend = createBoolean("recommend");
    
    public final StringPath recommendComment = createString("recommendComment");
    
    public final NumberPath<Integer> relationshipWithStaff = createNumber("relationshipWithStaff", Integer.class);
    
    public final NumberPath<Integer> reliability = createNumber("reliability", Integer.class);
    
    public final StringPath responsibilitiesExtraCurricular = createString("responsibilitiesExtraCurricular");
    
    public final BooleanPath safeguardingIssues = createBoolean("safeguardingIssues");
    
    public final BooleanPath senco = createBoolean("senco");
    
    public final BooleanPath senPlan = createBoolean("senPlan");
    
    public final NumberPath<Integer> sociability = createNumber("sociability", Integer.class);
    
    public final QStudent student;
    
    public final NumberPath<Integer> studentId = createNumber("studentId", Integer.class);
    
    public final NumberPath<Integer> workEthic = createNumber("workEthic", Integer.class);
    
    public final NumberPath<Double> year10Attendance = createNumber("year10Attendance", Double.class);
    
    public final StringPath year10AttendanceComment = createString("year10AttendanceComment");
    
    public final NumberPath<Double> year11Attendance = createNumber("year11Attendance", Double.class);
    
    public final StringPath year11AttendanceComment = createString("year11AttendanceComment");
    
    public QSchoolReference(
        String variable) {
        this(SchoolReference.class, forVariable(variable), INITS);
    }
    
    public QSchoolReference(
        Path<? extends SchoolReference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QSchoolReference(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QSchoolReference(
        PathMetadata metadata,
        PathInits inits) {
        this(SchoolReference.class, metadata, inits);
    }
    
    public QSchoolReference(
        Class<? extends SchoolReference> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
