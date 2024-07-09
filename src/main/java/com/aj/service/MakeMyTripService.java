package com.aj.service;

import com.aj.request.Passenger;
import com.aj.response.Ticket;

public interface MakeMyTripService {

	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicketByNumI(Integer ticketNumber);
}
