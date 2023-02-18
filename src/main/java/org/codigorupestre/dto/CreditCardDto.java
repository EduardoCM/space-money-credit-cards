package org.codigorupestre.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class CreditCardDto implements Serializable {
	
	private static final long serialVersionUID = -7509392962763636476L;

	public Integer id;

	public String cardHolderName;

	public String creditCardNumber;

	public String expirationDate;

	public String paymentNetworks;

	public String cvv;

	public Timestamp created;

	@Override
	public String toString() {
		return "CreditCardDto [id=" + id + ", cardHolderName=" + cardHolderName + ", creditCardNumber="
				+ creditCardNumber + ", expirationDate=" + expirationDate + ", paymentNetworks=" + paymentNetworks
				+ ", cvv=" + cvv + ", created=" + created + "]";
	}
	
	

}
