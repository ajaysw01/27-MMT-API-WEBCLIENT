package com.aj.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.aj.request.Passenger;
import com.aj.response.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {

	private String BOOK_TICKET_URL="http://12.232.253.164:8081/ticket";
	
	private String GET_TICKET_URL ="http:12.232.253.164.8081/ticket/{ticketNum}";
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		WebClient webclient = WebClient.create();
		
		//send post req with passenger data
		//and map response to Ticket obj
		Ticket ticket = 
				webclient.post()
				.uri(BOOK_TICKET_URL)
				.bodyValue(passenger)
				.retrieve()
				.bodyToMono(Ticket.class)//convert ticket json to ticket object
				.block();
				
		return ticket;
	}

	@Override
	public Ticket getTicketByNumI(Integer ticketNumber) {

		//get the instance of weclinet impl class
		WebClient webClient = WebClient.create();
		
		//send get req and map response to Ticket obj
		Ticket ticket = webClient.get()
				.uri(GET_TICKET_URL,ticketNumber)
				.retrieve()
				.bodyToMono(Ticket.class)//whaterver json store it to ticket obj
				.block();// once we got resp return it to object
		
		return ticket;
	}

}
