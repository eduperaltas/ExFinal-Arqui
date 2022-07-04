package com.example.microservice.api.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("FortlomMappingConfiguration")
public class MappingConfiguration {


    @Bean    public TrasladoMapper trasladoMapper() {
        return new TrasladoMapper();
    }
    @Bean
    public TicketMapper ticketMapper() {
        return new TicketMapper();
    }





}
