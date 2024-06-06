package com.trycatchfactory.clean.infraestructure.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ComentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;
}
