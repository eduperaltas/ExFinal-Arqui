package com.example.microservice.api.resource.Traslado;

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
public class TrasladoResource {
    private Long id;

    private String nombreCliente;

    private String lugRecogida;

    private String lugDestino;

    private String Comentarios;

    private String fecha;

    private String hora;
}
