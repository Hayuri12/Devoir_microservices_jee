package com.mesCommande.microservicecommandes.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

public class AddNewCmd extends RuntimeException{
	public AddNewCmd(String a) {
		super(a);
	}

}
