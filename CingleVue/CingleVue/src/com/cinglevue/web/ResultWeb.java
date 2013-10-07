package com.cinglevue.web;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.cinglevue.model.Result;
import com.cinglevue.model.School;
import com.cinglevue.model.Subject;

/**
 * This class interact with the RESTFUL requests from the front end. 
 * @author RSenarath
 *
 */
@Path("/result")
public class ResultWeb {
	
	static Logger log = Logger.getLogger(ResultWeb.class.getName());
	
	/**
	 * Return JSON object of results for the requested subject.
	 * 
	 * @param subject
	 * @return
	 */
	@GET
	@Path("/get/{subject}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Result> testQuery(@PathParam("subject") String subject){
		
		log.info("Returns resuls for specific subjects");
		log.debug("Requested Subject : "+ subject);
		
		/*ResultDAO resultdao = new ResultDAOImpl();
		return resultdao.getResult(subject);*/
		
		School school = new School();
		school.setName("St. Ana Paloma College");
		
		Subject sub = new Subject();
		sub.setName("Reading");
		
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
		result.setSubject(sub);
		
		List<Result> res = new LinkedList<Result>();
		res.add(result);
		log.info("Results fetched");
		return res;
	}
}
