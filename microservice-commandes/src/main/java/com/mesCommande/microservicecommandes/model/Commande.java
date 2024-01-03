package com.mesCommande.microservicecommandes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
	@Id
    @GeneratedValue
	private Integer id;
		
	private String description;
	
	private int quantity;

    private Date date;
    
    private int montant;
    
   

	
	

}
