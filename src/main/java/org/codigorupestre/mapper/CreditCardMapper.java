package org.codigorupestre.mapper;

import org.codigorupestre.domain.CreditCard;
import org.codigorupestre.dto.CreditCardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CreditCardMapper {

	
	CreditCard toDomain(CreditCardDto dto);
	
	
}
