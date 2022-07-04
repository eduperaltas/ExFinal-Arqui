package com.example.microservice.api.domain.persistence;

import com.example.microservice.api.domain.model.entity.Traslado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrasladoRepository extends JpaRepository<Traslado,Long> {

}
