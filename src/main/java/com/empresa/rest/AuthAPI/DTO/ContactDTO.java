package com.empresa.rest.AuthAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDTO {

    private Long id;
    private String correo;
    private String ciudad;
    private String fechaAlta;
    private int unidades;
}
