package com.trycatchfactory.clean.infraestructure.persistence;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataComentRepository extends CrudRepository<ComentEntity,String> {
}
