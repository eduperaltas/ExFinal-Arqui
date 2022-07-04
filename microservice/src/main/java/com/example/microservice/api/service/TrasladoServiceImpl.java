package com.example.microservice.api.service;

import com.example.microservice.api.domain.model.entity.Traslado;
import com.example.microservice.api.domain.persistence.TrasladoRepository;
import com.example.microservice.api.domain.service.TrasladoService;
import com.example.microservice.api.resource.Traslado.CreateTrasladoResource;
import com.example.microservice.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrasladoServiceImpl implements TrasladoService {
    private static final String ENTITY = "Traslado";
    private  final TrasladoRepository trasladoRepository;

    public TrasladoServiceImpl(TrasladoRepository trasladoRepository) {
        this.trasladoRepository = trasladoRepository;
    }

    @Override
    public List<Traslado> getAll() {
        return trasladoRepository.findAll();
    }

    @Override
    public Traslado create(CreateTrasladoResource request) {
        Traslado tras = new Traslado();
        tras.setComentarios(request.getComentarios());
        tras.setFecha(request.getFecha());
        tras.setHora(request.getHora());
        tras.setLugDestino(request.getLugDestino());
        tras.setLugRecogida(request.getLugRecogida());
        tras.setNombreCliente(request.getNombreCliente());

        return trasladoRepository.save(tras);
    }

    @Override
    public Traslado update(Long id, Traslado request) {
        return trasladoRepository.findById(id).map( pub ->
                        trasladoRepository.save(
                                pub.withComentarios(request.getComentarios())
                                        .withFecha(request.getFecha())
                                        .withHora(request.getHora())
                                        .withLugDestino(request.getLugDestino())
                                        .withLugRecogida(request.getLugRecogida())
                                        .withNombreCliente(request.getNombreCliente())
                        ))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, request.getId()));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return trasladoRepository.findById(id).map( pub -> {
            trasladoRepository.delete(pub);
            return ResponseEntity.ok().build();
        }).orElseThrow((() -> new ResourceNotFoundException(ENTITY, id)));
    }
}
