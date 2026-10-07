package com.salesianostriana.edu.tarea4DTOs.dtos;

import com.salesianostriana.edu.tarea4DTOs.model.Autor;
import com.salesianostriana.edu.tarea4DTOs.model.Libro;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record LibroDTO(String titulo, String isbn, String autor, Integer anioPublicacion) {

    public static LibroDTO from(Libro libro) {
        if (libro == null) {
            return null;
        }

        Autor autor = libro.getAutor();
        String nombreAutor = autor == null
                ? ""
                : Stream.of(autor.getNombre(), autor.getApellido1(), autor.getApellido2())
                        .filter(nombre -> nombre != null && !nombre.isBlank())
                        .collect(Collectors.joining(" "));

        return new LibroDTO(libro.getTitulo(), libro.getIsbn(), nombreAutor, libro.getAnioPublicacion());
    }
}
