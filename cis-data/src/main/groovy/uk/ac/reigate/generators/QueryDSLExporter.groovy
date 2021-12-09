package uk.ac.reigate.generators

import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.MappedSuperclass
import javax.persistence.Transient

import com.querydsl.codegen.GenericExporter
import com.querydsl.codegen.Keywords

class QueryDSLExporter {
    
    static main(args) {
        System.out.println("QueryDSL Generator Started");
        GenericExporter exporter = new GenericExporter();
        exporter.setKeywords(Keywords.JPA);
        exporter.setEntityAnnotation(Entity.class);
        exporter.setEmbeddableAnnotation(Embeddable.class);
        exporter.setEmbeddedAnnotation(Embedded.class);
        exporter.setSupertypeAnnotation(MappedSuperclass.class);
        exporter.setSkipAnnotation(Transient.class);
        exporter.setTargetFolder(new File("src/main/generated-sources"));
        exporter.export('uk.ac.reigate.domain');
        System.out.println("QueryDSL Generator Complete");
    }
}
