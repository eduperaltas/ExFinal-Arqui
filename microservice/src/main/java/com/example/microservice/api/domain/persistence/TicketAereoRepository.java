package com.example.microservice.api.domain.persistence;

import com.example.microservice.api.domain.model.entity.TicketAereo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketAereoRepository extends JpaRepository<TicketAereo,Long> {

}
