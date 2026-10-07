package com.salesianostriana.edu.tarea4DTOs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {

    private Long id;
    private String nombre;
    private String titulo;
    private String isbn;
    private Integer anioPublicacion;
    private Integer numeroPaginas;
    private Autor autor;

}
