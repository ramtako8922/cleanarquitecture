package com.trycatchfactory.clean.domain.usecase;

import com.trycatchfactory.clean.domain.entity.Coment;
import com.trycatchfactory.clean.domain.repositoy.ComentRepository;

public class ComentUseCase {

    private final ComentRepository comentRepository;

    public ComentUseCase(ComentRepository comentRepository) {
        this.comentRepository = comentRepository;


    }

    public  void  execute (Coment coment){
        comentRepository.save(coment);
    }

    public Coment getComentById(String id){
        return  comentRepository.findById(id);
    }
}
