package com.cinglevue.service;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cinglevue.dao.ResultDAO;
import com.cinglevue.dao.ResultDAOImpl;
import com.cinglevue.model.Result;
import com.cinglevue.model.School;
import com.cinglevue.model.Subject;

@Path("/result")
public class ResultService {

	private static List<Result> reading = new LinkedList<Result>();
	private static List<Result> spelling = new LinkedList<Result>();
	private static List<Result> numeracy = new LinkedList<Result>();

	static {

		Result sr1 = new Result();
		//School sc1 = new School();
		//sc1.setName("St. Aaron College");
		
		//sr1.setSchool(sc1);
		sr1.setY3(412.48);
		sr1.setY5(515.73);
		sr1.setY7(0);
		sr1.setY9(0);
		sr1.setRawGainY3ToY5(84.38);
		sr1.setFactoredGainY3ToY5(72.36);
		sr1.setcLGGainY3ToY5(85.52);
		sr1.setGainInGainY3ToY5(31.00);

		reading.add(sr1);

		Result sr2 = new Result();
		//School sc2 = new School();
		//sc2.setName("St. Alan College");
		
		//sr2.setSchool(sc2);
		sr2.setY3(212.48);
		sr2.setY5(125.73);
		sr2.setY7(234);
		sr2.setY9(34.33);
		sr2.setRawGainY3ToY5(184.38);
		sr2.setFactoredGainY3ToY5(2.36);
		sr2.setcLGGainY3ToY5(825.52);
		sr2.setGainInGainY3ToY5(331.00);

		spelling.add(sr2);

		Result sr3 = new Result();
		//School sc3 = new School();
		//sc3.setName("St. Alexander College");
		
		//sr3.setSchool(sc3);
		sr3.setY3(12.48);
		sr3.setY5(15.73);
		sr3.setY7(23);
		sr3.setY9(3.33);
		sr3.setRawGainY3ToY5(14.38);
		sr3.setFactoredGainY3ToY5(42.36);
		sr3.setcLGGainY3ToY5(85.52);
		sr3.setGainInGainY3ToY5(31.00);

		numeracy.add(sr3);
		
		Result sr4 = new Result();
		//School sc4 = new School();
		//sc4.setName("Dhrmashoka College Galle");
		
		//sr4.setSchool(sc4);
		sr4.setY3(12.48);
		sr4.setY5(15.73);
		sr4.setY7(23);
		sr4.setY9(3.33);
		sr4.setRawGainY3ToY5(14.38);
		sr4.setFactoredGainY3ToY5(42.36);
		sr4.setcLGGainY3ToY5(85.52);
		sr4.setGainInGainY3ToY5(31.00);
		
		numeracy.add(sr4);
	}

	@GET
	@Path("/json/{filter}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Result> getSchoolResult(@PathParam("filter") String filter) {
		if (filter.equals("numeracy")) {
			return numeracy;
		} else if (filter.equals("spelling")) {
			return spelling;
		} else {
			return reading;
		}
	}

	@GET
	@Path("/json/single")
	@Produces(MediaType.APPLICATION_JSON)
	public Result getSchool() {
		Result sr1 = new Result();

		sr1.setY3(412.48);
		sr1.setY5(515.73);
		sr1.setY7(0);
		sr1.setY9(0);
		sr1.setRawGainY3ToY5(84.38);
		sr1.setFactoredGainY3ToY5(72.36);
		sr1.setcLGGainY3ToY5(85.52);
		sr1.setGainInGainY3ToY5(31.00);

		return sr1;
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Result test(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mongo-example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//==========================================================
		School school = new School();
		school.setName("St. Ana Paloma College");
		
		Subject subject = new Subject();
		subject.setName("Reading");
		
		Result result = new Result();
		result.setY3(200.66);
		result.setY5(22.52);
		result.setY7(342.34);
		result.setY9(90.34);
		result.setRawGainY3ToY5(60.84);
		result.setFactoredGainY3ToY5(70.05);
		result.setcLGGainY3ToY5(12.91);
		result.setGainInGainY3ToY5(76.00);
		result.setSchool(school);
		result.setSubject(subject);
		
		//==========================================================
		
		em.persist(result);
		em.getTransaction().commit();
		String oid = result.getId();
		System.out.println("===================> " + oid);

		Result sch = em.find(Result.class, oid);
		System.out.println("Found Result:" + sch + " by its oid: " + oid);
		em.close();
		return result;
	}
	
	@GET
	@Path("/get/{subject}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Result> testQuery(@PathParam("subject") String subject){
		ResultDAO resultdao = new ResultDAOImpl();
		return resultdao.getResult(subject);
	}
}
