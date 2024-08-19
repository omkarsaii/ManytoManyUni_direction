package com.jsp.ManytoManyUnidirection.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.ManytoManyUnidirection.dta.Language;
import com.jsp.ManytoManyUnidirection.dta.Person;

public class PersonDao {

	
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkarr");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveperson(Person person)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
//		 entityManager.merge(person);
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void saveLanguage(Language language)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
//		entityManager.merge(language);
		entityManager.persist(language);
		entityTransaction.commit();
		
	}
	
	public void updateperson(int id, Person person)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person1=entityManager.find(Person.class,id);
		
		if(person1!=null)
		{
			person.setId(id);
			person.setList(person1.getList());
		    entityTransaction.begin();
		    entityManager.merge(person);
		    entityTransaction.commit();
		}
		else
		{
			System.out.println("person id doesnt exist");
		}
		
	}
	
	public void deleteperson(int id)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class,id);
		
		if(person!=null)
		{
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		}
		else {
			System.out.println("person doesnt exist");
		}
	}
	
}
