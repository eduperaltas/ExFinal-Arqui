package com.example.microservice.api.domain.service;


import com.example.microservice.api.domain.model.entity.TicketAereo;
import com.example.microservice.api.resource.TicketAereo.CreateTicketResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketService {
    List<TicketAereo> getAll();
    TicketAereo create(CreateTicketResource request);
    TicketAereo update(Long id ,TicketAereo publicacionForo);
    ResponseEntity<?> delete(Long PublicacionForoId);
}
