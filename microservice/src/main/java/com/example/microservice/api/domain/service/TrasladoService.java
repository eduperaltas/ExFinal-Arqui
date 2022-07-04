package com.example.microservice.api.domain.service;


import com.example.microservice.api.domain.model.entity.Traslado;
import com.example.microservice.api.resource.Traslado.CreateTrasladoResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TrasladoService {
    List<Traslado> getAll();
    Traslado create(CreateTrasladoResource request);
    Traslado update(Long id ,Traslado publicacionForo);
    ResponseEntity<?> delete(Long PublicacionForoId);
}
