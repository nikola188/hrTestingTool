package Beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Technology.class)
public abstract class Technology_ {

	public static volatile CollectionAttribute<Technology, Question> questionCollection;
	public static volatile CollectionAttribute<Technology, Result> resultCollection;
	public static volatile CollectionAttribute<Technology, CandidateTechnology> candidateTechnologyCollection;
	public static volatile SingularAttribute<Technology, Integer> id;
	public static volatile SingularAttribute<Technology, String> text;

}

