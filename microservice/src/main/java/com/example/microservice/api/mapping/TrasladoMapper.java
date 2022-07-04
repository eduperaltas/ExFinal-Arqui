package com.example.microservice.api.mapping;

import com.example.microservice.api.domain.model.entity.Traslado;
import com.example.microservice.api.resource.Traslado.CreateTrasladoResource;
import com.example.microservice.api.resource.Traslado.TrasladoResource;
import com.example.microservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TrasladoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public TrasladoResource toResource(Traslado req) {
        return mapper.map(req, TrasladoResource.class);
    }

    public Page<TrasladoResource> modelListToPage(List<Traslado> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, TrasladoResource.class), pageable, modelList.size());
    }

    public Traslado toModel(CreateTrasladoResource req) {
        return mapper.map(req, Traslado.class);
    }
}
