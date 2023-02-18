package org.codigorupestre.trasformer;

import javax.enterprise.context.ApplicationScoped;

import org.codigorupestre.domain.CreditCard;
import org.codigorupestre.entity.CreditCardEntity;

@ApplicationScoped
public class SpaceMoneyTransformer {
	
	
	
	public CreditCardEntity toEntity(CreditCard creditCard) {
		CreditCardEntity entity = new CreditCardEntity();
		
		entity.cardHolderName = creditCard.cardHolderName;
		entity.creditCardNumber = creditCard.creditCardNumber;
		entity.expirationDate = creditCard.expirationDate;
		entity.paymentNetworks = creditCard.paymentNetworks;
		entity.cvv = creditCard.cvv;
		
		return entity;
	}
	
	
	public CreditCard toDomain(CreditCardEntity creditCard) {
		CreditCard domain = new CreditCard();
		
		domain.cardHolderName = creditCard.cardHolderName;
		domain.creditCardNumber = creditCard.creditCardNumber;
		domain.expirationDate = creditCard.expirationDate;
		domain.paymentNetworks = creditCard.paymentNetworks;
		domain.cvv = creditCard.cvv;
		
		return domain;
	}

}
