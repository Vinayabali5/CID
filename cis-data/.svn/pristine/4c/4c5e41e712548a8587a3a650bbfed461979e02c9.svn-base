package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCourse is a Querydsl query type for Course
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourse extends EntityPathBase<Course> {
    
    private static final long serialVersionUID = -593449479L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QCourse course = new QCourse("course");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final ListPath<CourseGroup, QCourseGroup> courseGroups = this.<CourseGroup, QCourseGroup> createList("courseGroups", CourseGroup.class, QCourseGroup.class, PathInits.DIRECT2);
    
    public final StringPath courseSummary = createString("courseSummary");
    
    public final StringPath entryRequirements = createString("entryRequirements");
    
    public final uk.ac.reigate.domain.exams.QExamBoard examBoard;
    
    public final StringPath externalLink = createString("externalLink");
    
    public final BooleanPath externallyAssessed = createBoolean("externallyAssessed");
    
    public final NumberPath<Integer> glh = createNumber("glh", Integer.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final StringPath learningAimReference = createString("learningAimReference");
    
    public final uk.ac.reigate.domain.lookup.QLevel level;
    
    public final StringPath locationPostcode = createString("locationPostcode");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath notes = createString("notes");
    
    public final BooleanPath published = createBoolean("published");
    
    public final StringPath publishedTitle = createString("publishedTitle");
    
    public final NumberPath<Integer> rqfLevelOverride = createNumber("rqfLevelOverride", Integer.class);
    
    public final BooleanPath russell = createBoolean("russell");
    
    public final StringPath spec = createString("spec");
    
    public final uk.ac.reigate.domain.lookup.QSubject subject;
    
    public final StringPath subjectSectorArea = createString("subjectSectorArea");
    
    public final StringPath syllabusCode = createString("syllabusCode");
    
    public final StringPath ucasTitle = createString("ucasTitle");
    
    public final QAcademicYear validFrom;
    
    public final QAcademicYear validTo;
    
    public QCourse(
        String variable) {
        this(Course.class, forVariable(variable), INITS);
    }
    
    public QCourse(
        Path<? extends Course> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QCourse(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QCourse(
        PathMetadata metadata,
        PathInits inits) {
        this(Course.class, metadata, inits);
    }
    
    public QCourse(
        Class<? extends Course> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examBoard = inits.isInitialized("examBoard") ? new uk.ac.reigate.domain.exams.QExamBoard(forProperty("examBoard")) : null;
        this.level = inits.isInitialized("level") ? new uk.ac.reigate.domain.lookup.QLevel(forProperty("level"), inits.get("level")) : null;
        this.subject = inits.isInitialized("subject") ? new uk.ac.reigate.domain.lookup.QSubject(forProperty("subject")) : null;
        this.validFrom = inits.isInitialized("validFrom") ? new QAcademicYear(forProperty("validFrom")) : null;
        this.validTo = inits.isInitialized("validTo") ? new QAcademicYear(forProperty("validTo")) : null;
    }
    
}
