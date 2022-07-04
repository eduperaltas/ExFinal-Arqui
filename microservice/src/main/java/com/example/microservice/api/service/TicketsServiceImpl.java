package com.example.microservice.api.service;


import com.example.microservice.api.domain.model.entity.TicketAereo;
import com.example.microservice.api.domain.persistence.TicketAereoRepository;
import com.example.microservice.api.domain.service.TicketService;
import com.example.microservice.api.resource.TicketAereo.CreateTicketResource;
import com.example.microservice.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketsServiceImpl implements TicketService {
    private static final String ENTITY = "Ticket";
    private  final TicketAereoRepository ticketAereoRepository;

    public TicketsServiceImpl(TicketAereoRepository ticketAereoRepository) {
        this.ticketAereoRepository = ticketAereoRepository;
    }

    @Override
    public List<TicketAereo> getAll() {
        return ticketAereoRepository.findAll();
    }

    @Override
    public TicketAereo create(CreateTicketResource request) {
        TicketAereo tras = new TicketAereo();
        tras.setComentarios(request.getComentarios());
        tras.setFecha(request.getFecha());
        tras.setHora(request.getHora());
        tras.setLugDestino(request.getLugDestino());
        tras.setLugPartida(request.getLugPartida());
        tras.setNombreCliente(request.getNombreCliente());
        tras.setNombreAerolinea(request.getNombreAerolinea());
        
        return ticketAereoRepository.save(tras);
    }

    @Override
    public TicketAereo update(Long id, TicketAereo request) {
        return ticketAereoRepository.findById(id).map( pub ->
                        ticketAereoRepository.save(
                                pub.withComentarios(request.getComentarios())
                                        .withFecha(request.getFecha())
                                        .withHora(request.getHora())
                                        .withLugDestino(request.getLugDestino())
                                        .withLugPartida(request.getLugPartida())
                                        .withNombreCliente(request.getNombreCliente())
                                        .withNombreAerolinea(request.getNombreAerolinea())
                        ))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, request.getId()));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return ticketAereoRepository.findById(id).map( pub -> {
            ticketAereoRepository.delete(pub);
            return ResponseEntity.ok().build();
        }).orElseThrow((() -> new ResourceNotFoundException(ENTITY, id)));
    }
}
