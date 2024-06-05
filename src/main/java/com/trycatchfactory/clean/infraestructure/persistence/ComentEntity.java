package com.trycatchfactory.clean.infraestructure.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Coment")
public class ComentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String title;

    private String content;
}
