package com.cognizant.spring.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring.mysql.dao.TicketDao;
import com.cognizant.spring.mysql.model.Ticket;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
	private TicketDao dao;
    
    @PostMapping("/bookTickets")
    public String bookTicket( @RequestBody List<Ticket> tickets) {
    	
    	dao.saveAll(tickets);
    	return "ticket booked :"+ tickets.size();
    }
    @GetMapping("/getTickets")
    public List<Ticket> getTicket(){
    	
    	return (List<Ticket>) dao.findAll();
    }
    @DeleteMapping("/cancel/{id}")
    public List<Ticket> cancelTicket(@PathVariable int id)
    {
    	dao.deleteById(id);
    	return (List<Ticket>) dao.findAll();
    }
    
    
}
