package com.salesianostriana.edu.tarea4DTOs.dtos;

import com.salesianostriana.edu.tarea4DTOs.model.Autor;
import com.salesianostriana.edu.tarea4DTOs.model.Libro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LibroDTOTest {

    @Test
    void fromReturnsNullWhenBookIsNull() {
        assertNull(LibroDTO.from(null));
    }

    @Test
    void fromMapsBookWithCompleteAuthor() {
        Libro libro = Libro.builder()
                .titulo("El libro")
                .isbn("123")
                .anioPublicacion(2024)
                .autor(Autor.builder()
                        .nombre("Ada")
                        .apellido1("Lovelace")
                        .apellido2("Byron")
                        .build())
                .build();

        assertEquals(new LibroDTO("El libro", "123", "Ada Lovelace Byron", 2024), LibroDTO.from(libro));
    }

    @Test
    void fromHandlesMissingAuthorAndSecondSurname() {
        Libro sinAutor = Libro.builder().titulo("Sin autor").build();
        Libro conApellidoOpcional = Libro.builder()
                .autor(Autor.builder().nombre("Ada").apellido1("Lovelace").build())
                .build();

        assertEquals("", LibroDTO.from(sinAutor).autor());
        assertEquals("Ada Lovelace", LibroDTO.from(conApellidoOpcional).autor());
    }

    @Test
    void fromOmitsMissingPartsOfAuthorName() {
        Libro libro = Libro.builder()
                .autor(Autor.builder().nombre("Ada").apellido2("Byron").build())
                .build();

        assertEquals("Ada Byron", LibroDTO.from(libro).autor());
    }
}
