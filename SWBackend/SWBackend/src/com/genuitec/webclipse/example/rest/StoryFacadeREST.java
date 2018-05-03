package com.genuitec.webclipse.example.rest;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.genuitec.webclipse.example.EntityManagerHelper;
import com.genuitec.webclipse.example.Person;
import com.genuitec.webclipse.example.Story;

/**
 * @author MyEclipse Web Service Tools
 */
@javax.inject.Singleton
@Path("Story/")
@WebService
public class StoryFacadeREST extends AbstractFacade<Story> {

	private EntityManager em;

	public StoryFacadeREST() {
		super(Story.class);
	}	

	@PUT
	@Override
	@Consumes({ "application/xml", "application/json" })
	public Response edit(Story entity) {
		if (entity.getName().length() <= 3) {
			return Response.status(Status.CONFLICT).entity("Customer name is too short").type(MediaType.TEXT_PLAIN).build();
		}
		return super.edit(entity);
	}

	@DELETE
	@Path("remove/{id}")
	public Response remove(@PathParam("id") Integer id) {
		return super.remove(super.find(id));
	}

	@GET
	@Path("{id}")
	@Produces({ "application/json" })
	public Story find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
	@Override
	@Produces({ "application/json" })
	public List<Story> findAll() {
		return super.findAll();
	}

	@GET
	@Path("{from}/{to}")
	@Produces({ "application/xml", "application/json" })
	public List<Story> findRange(@PathParam("from") Integer from,
			@PathParam("to") Integer to) {
		return super.findRange(new int[] { from, to });
	}

	@GET
	@Path("count")
	@Produces("text/plain")
	public String countREST() {
		return String.valueOf(super.count());
	}

	@GET
	@Path("findOfPerson/{id}")
	@Produces({"application/json"})
	public List<Story> findOfPerson(@PathParam("id") Integer id) {
		TypedQuery<Story> query = getEntityManager().
				createQuery("select s from Story s where s.personId = :id", Story.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@PUT
	@Path("logWork/{id}/{personId}/{hours}")
	@Produces({"application/json"})
	public void logWork(@PathParam("id") Integer id, @PathParam("personId") Integer personId, @PathParam("hours") Integer hours) {
		getEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		Query query = em.
				createQuery("update Story s set s.hours = (s.hours + :hours) where s.id = :id");
		query.setParameter("id", id);
		query.setParameter("hours", hours);
		query.executeUpdate();
		
		Query query1 = em.createQuery("update Person p set p.totalHours = (p.totalHours + :hours) where p.id = :personId");
		query1.setParameter("personId", personId);
		query1.setParameter("hours", hours);
		query1.executeUpdate();
		
		Query query2 = em.createQuery("update Person p set p.totalPay = (p.totalHours * p.rate) where p.id = :personId");
		query2.setParameter("personId", personId);
		query2.executeUpdate();
		tr.commit();
	}

	@Override
	protected EntityManager getEntityManager() {
		em = EntityManagerHelper.getEntityManager();
		return em;
	}
}
	