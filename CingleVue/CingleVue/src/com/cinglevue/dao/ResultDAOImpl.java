package com.cinglevue.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cinglevue.model.Result;

/**
 * 
 * @author ravinda
 *
 */
public class ResultDAOImpl implements ResultDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Result> getResult(String subject) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mongo-example");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("Select o from Result o where o.subject.name = '"+ subject +"'");
		List<Result> result = (List<Result>)query.getResultList();
		em.close();
		return result;
	}

}
