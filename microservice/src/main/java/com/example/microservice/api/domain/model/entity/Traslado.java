package com.example.microservice.api.domain.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@With
@Table(name = "Traslados")
public class Traslado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String nombreCliente;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String lugRecogida;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String lugDestino;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String Comentarios;
    @NotNull
    @NotBlank
    private String fecha;
    @NotNull
    @NotBlank
    private String hora;
}
