package com.mesCommande.microservicecommandes.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoCmdFound extends RuntimeException{
	public NoCmdFound(String a) {
		super(a);
	}

}
