package com.example.microservice.api.resource.TicketAereo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateTicketResource {
    @NotNull
    @NotBlank
    private String nombreCliente;
    @NotNull
    @NotBlank
    private String nombreAerolinea;
    @NotNull
    @NotBlank
    private String lugPartida;
    @NotNull
    @NotBlank
    private String lugDestino;

    private String Comentarios;
    @NotNull
    @NotBlank
    private String fecha;
    @NotNull
    @NotBlank
    private String hora;
}
