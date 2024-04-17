package com.empresa.rest.AuthAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contacto")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Correo_de_contacto")
    private String correo;

    @Column(name = "Ciudad")
    private String ciudad;

    @Column(name = "Fecha_de_alta")
    private String fechaAlta;

    @Column(name = "Unidades")
    private int unidades;
}