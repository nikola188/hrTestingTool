package Beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Candidate.class)
public abstract class Candidate_ {

	public static volatile SingularAttribute<Candidate, String> firstName;
	public static volatile SingularAttribute<Candidate, String> lastName;
	public static volatile CollectionAttribute<Candidate, Result> resultCollection;
	public static volatile CollectionAttribute<Candidate, CandidateTechnology> candidateTechnologyCollection;
	public static volatile SingularAttribute<Candidate, Integer> id;

}

