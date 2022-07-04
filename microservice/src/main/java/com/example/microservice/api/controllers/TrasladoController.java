package com.example.microservice.api.controllers;

import com.example.microservice.api.domain.service.TrasladoService;
import com.example.microservice.api.mapping.TrasladoMapper;
import com.example.microservice.api.resource.Traslado.CreateTrasladoResource;
import com.example.microservice.api.resource.Traslado.TrasladoResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/traslados")
@Tag(name = "Traslados")
public class TrasladoController {
    @Autowired
    TrasladoService trasladoService;
    @Autowired
    TrasladoMapper mapper;

    @GetMapping
    public Page<TrasladoResource> getAllTraslados(Pageable pageable){
        return mapper.modelListToPage(trasladoService.getAll(), pageable);
    }

    @PostMapping
    public TrasladoResource createTraslados(@RequestBody CreateTrasladoResource resource){
        return mapper.toResource(trasladoService.create(resource));
    }

    @PutMapping("/{id}")
    public TrasladoResource updateTraslados(@PathVariable Long id ,@RequestBody CreateTrasladoResource resource){
        return mapper.toResource(trasladoService.update(id,mapper.toModel(resource)));
    }

    @DeleteMapping("/{id}")
    public void deleteTraslados(@PathVariable Long id){
        trasladoService.delete(id);
    }
}
