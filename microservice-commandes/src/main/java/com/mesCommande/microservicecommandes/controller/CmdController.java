package com.mesCommande.microservicecommandes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mesCommande.microservicecommandes.Exceptions.AddNewCmd;
import com.mesCommande.microservicecommandes.Exceptions.NoCmdFound;
import com.mesCommande.microservicecommandes.configurations.ApplicationPropertiesConfiguration;
import com.mesCommande.microservicecommandes.dao.ICmdDao;
import com.mesCommande.microservicecommandes.model.Commande;

@RestController
public class CmdController implements HealthIndicator {
	@Autowired
	private ICmdDao icmdao;

	@Autowired
	ApplicationPropertiesConfiguration apc;

	@PostMapping(value = "/commandes")
	public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {
		Commande newCmd = icmdao.save(commande);
		if (newCmd == null) {
			throw new AddNewCmd("Impossible d'ajouter cette commande");
		}
		return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
	}

	@GetMapping(value = "/listAll")
	public List<Commande> listeDesCommandes() {

		List<Commande> commande = icmdao.findAll();

		if (commande.isEmpty()) {
			throw new NoCmdFound("Aucune commande n'est disponible à la vente");
		} else {
			int startIndex = Math.max(commande.size() - apc.getLastCommandes(), 0);
			return commande.subList(startIndex, commande.size());

		}

		// List<Commande> ListeLast = commande.subList(0,apc.getCommandesLast())

	}

	@GetMapping(value = "/commandes/{id}")
	public Optional<Commande> recupererUneCommande(@PathVariable int id) {

		Optional<Commande> commande = icmdao.findById(id);

		if (!commande.isPresent())
			throw new NoCmdFound("Cette commande n'existe pas");

		return commande;
	}

	@DeleteMapping(value = "/cmd/{id}")
	public ResponseEntity<String> deleteCommande(@PathVariable int id) {
	    Optional<Commande> existingCommande = icmdao.findById(id);

	    if (existingCommande.isPresent()) {
	        icmdao.deleteById(id);
	        return new ResponseEntity<>("Commande with ID " + id + " has been deleted", HttpStatus.OK);
	    } else {
	        throw new NoCmdFound("Aucune commande trouvée avec l'ID " + id);
	    }
	}


	@Override
	public Health health() {
		List<Commande> commande = icmdao.findAll();
		if (commande.isEmpty()) {
			return Health.down().build();
		}
		return Health.up().build();
	}

}
