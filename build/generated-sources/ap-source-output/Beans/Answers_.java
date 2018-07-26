package Beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Answers.class)
public abstract class Answers_ {

	public static volatile SingularAttribute<Answers, Question> idQuestion;
	public static volatile SingularAttribute<Answers, Integer> id;
	public static volatile SingularAttribute<Answers, String> text;
	public static volatile SingularAttribute<Answers, Boolean> isCorrect;

}

