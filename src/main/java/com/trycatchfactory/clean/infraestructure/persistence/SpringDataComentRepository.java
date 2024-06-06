package com.trycatchfactory.clean.infraestructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataComentRepository extends CrudRepository<ComentEntity,Long> {
}
