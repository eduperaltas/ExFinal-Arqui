package com.example.microservice.api.resource.TicketAereo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TicketResource {

    private Long id;

    private String nombreCliente;

    private String nombreAerolinea;

    private String lugPartida;

    private String lugDestino;

    private String Comentarios;

    private String fecha;

    private String hora;
}
