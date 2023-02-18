package org.codigorupestre.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.codigorupestre.domain.CreditCard;
import org.codigorupestre.entity.CreditCardEntity;
import org.codigorupestre.repository.CreditCardRepository;
import org.codigorupestre.trasformer.SpaceMoneyTransformer;
import org.jboss.logging.Logger;

import io.quarkus.logging.Log;

@ApplicationScoped
public class CreditCardService {
	
	@Inject
	private Logger logger;
	
	@Inject
	private CreditCardRepository repository;
	
	@Inject
	private SpaceMoneyTransformer transformer;
	
	public void create(CreditCard creditCard) {
		logger.info("Credit Card Service: " + creditCard);
		repository.persist(transformer.toEntity(creditCard));
		logger.info("Credit Card saved success");
	}
	
	public List<CreditCard> findAll() {
		logger.info("FindAll Service");
		 return repository.listAll().stream()
                 .map(creditCard -> transformer.toDomain(creditCard))
                 .collect(Collectors.toList());
	}
	
	
	public CreditCard findById(Integer id) {
		logger.info("FindBy ID " + id + " Service");
		 CreditCardEntity creditCard = repository.findById(id);
		 if(creditCard != null) {
			 return transformer.toDomain(creditCard);
		 }else {
			 return null;
		 }
	}
	
	public boolean deleteById(Integer id) {
		logger.info("Delete by ID: " + id);
		return repository.deleteById(id);
	}
	

}
