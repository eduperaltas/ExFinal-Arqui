package com.example.microservice.api.mapping;

import com.example.microservice.api.domain.model.entity.TicketAereo;
import com.example.microservice.api.resource.TicketAereo.CreateTicketResource;
import com.example.microservice.api.resource.TicketAereo.TicketResource;
import com.example.microservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TicketMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public TicketResource toResource(TicketAereo req) {
        return mapper.map(req, TicketResource.class);
    }

    public Page<TicketResource> modelListToPage(List<TicketAereo> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, TicketResource.class), pageable, modelList.size());
    }

    public TicketAereo toModel(CreateTicketResource req) {
        return mapper.map(req, TicketAereo.class);
    }
}
