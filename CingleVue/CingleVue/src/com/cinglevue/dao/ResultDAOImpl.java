package com.cinglevue.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.cinglevue.model.Result;

/**
 * MongoDB implementation of ResultDAO.
 * 
 * @author ravinda
 *
 */
public class ResultDAOImpl implements ResultDAO {

	static Logger log = Logger.getLogger(ResultDAOImpl.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public List<Result> getResult(String subject) {
		
		log.info("Access Mongodb table to retrieve subject results");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mongo-example");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("Select o from Result o where o.subject.name = '"+ subject +"'");
		
		log.debug("Query : "+query.toString());
		
		List<Result> result = (List<Result>)query.getResultList();
		em.close();
		return result;
	}

}
