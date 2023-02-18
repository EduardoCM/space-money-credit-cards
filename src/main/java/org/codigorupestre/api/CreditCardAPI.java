package org.codigorupestre.api;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codigorupestre.domain.CreditCard;
import org.codigorupestre.dto.CreditCardDto;
import org.codigorupestre.entity.CreditCardEntity;
import org.codigorupestre.mapper.CreditCardMapper;
import org.codigorupestre.service.CreditCardService;
import org.jboss.logging.Logger;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Path("/api/creditcard")
public class CreditCardAPI {

	@Inject
	private Logger logger;
	
	@Inject
	private CreditCardService service;
	
	@Inject
	private CreditCardMapper mapper;
	
	@POST
	public Response create(CreditCardDto creditCard) {
		logger.info("CreditCardAPI " + creditCard);
		service.create(mapper.toDomain(creditCard));
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Path("/all")
	public Response getAll() {
		return Response.status(Status.OK).entity(service.findAll()).build();

	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer id) {
		 CreditCard creditCard = service.findById(id);
		
		if(creditCard != null) {
			return Response.ok(creditCard).build();
		} else {
			return Response.noContent().build();
		}

	}

	@DELETE
	@Path("/{id}")
	public Response deleteById(@PathParam("id") Integer id) {
		boolean isDeleted = service.deleteById(id);
		return Response.ok(isDeleted).build();

	}

}
