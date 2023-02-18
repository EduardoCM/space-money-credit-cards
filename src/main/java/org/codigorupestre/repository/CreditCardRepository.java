package org.codigorupestre.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.codigorupestre.entity.CreditCardEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;


@Transactional
@ApplicationScoped
public class CreditCardRepository implements PanacheRepositoryBase<CreditCardEntity, Integer> {

}
