package Beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Question.class)
public abstract class Question_ {

	public static volatile SingularAttribute<Question, Boolean> multiAnswer;
	public static volatile CollectionAttribute<Question, Answers> answersCollection;
	public static volatile SingularAttribute<Question, Integer> id;
	public static volatile SingularAttribute<Question, String> text;
	public static volatile SingularAttribute<Question, Technology> idTechnology;
	public static volatile SingularAttribute<Question, Integer> points;

}

