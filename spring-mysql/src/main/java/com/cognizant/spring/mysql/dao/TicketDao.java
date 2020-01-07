package com.cognizant.spring.mysql.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.spring.mysql.model.Ticket;

public interface TicketDao extends CrudRepository<Ticket,Integer>{

}
