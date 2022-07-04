package com.example.microservice.api.controllers;

import com.example.microservice.api.domain.service.TicketService;
import com.example.microservice.api.mapping.TicketMapper;
import com.example.microservice.api.resource.TicketAereo.CreateTicketResource;
import com.example.microservice.api.resource.TicketAereo.TicketResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ticketsAereos")
@Tag(name = "tickets Aereos")
public class TicketsController {
    @Autowired
    TicketService ticketService;
    @Autowired
    TicketMapper mapper;

    @GetMapping
    public Page<TicketResource> getAllTicket(Pageable pageable){
        return mapper.modelListToPage(ticketService.getAll(), pageable);
    }

    @PostMapping
    public TicketResource createTicket(@RequestBody CreateTicketResource resource){
        return mapper.toResource(ticketService.create(resource));
    }

    @PutMapping("/{id}")
    public TicketResource updateTicket(@PathVariable Long id ,@RequestBody CreateTicketResource resource){
        return mapper.toResource(ticketService.update(id,mapper.toModel(resource)));
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketService.delete(id);
    }
}
