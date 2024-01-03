package com.mesCommande.microservicecommandes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mesCommande.microservicecommandes.model.Commande;

@Repository
public interface ICmdDao extends JpaRepository<Commande, Integer>{

}
