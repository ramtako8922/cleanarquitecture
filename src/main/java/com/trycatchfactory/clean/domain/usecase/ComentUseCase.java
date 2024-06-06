package com.trycatchfactory.clean.domain.usecase;

import com.trycatchfactory.clean.domain.entity.Coment;
import com.trycatchfactory.clean.domain.repositoy.ComentRepository;

import java.util.List;

public class ComentUseCase {

    private final ComentRepository comentRepository;

    /**
     * Constructor Method
     * @param comentRepository
     */
    public ComentUseCase(ComentRepository comentRepository) {
        this.comentRepository = comentRepository;


    }

    /**
     * Get all coments in domain levwl
     * @return
     */
    public List<Coment> getAllComents(){
        return comentRepository.findAll();
    }

    /**
     * Get coment by id in domain level
     * @param id
     * @return
     */
    public Coment getComentById(String id){
        return  comentRepository.findById(id);
    }

    /**
     * Save the comment in domain level
     * @param coment
     */
    public  void  saveComent (Coment coment){
        comentRepository.save(coment);
    }

    /**
     * Update comment in domain level
     * @param id
     * @param coment
     */

    public void updateComent (String id, Coment coment){
       comentRepository.update(id,coment);
    }

    /**
     * Delete coment by Id domain Level
     * @param id
     */
    public void deleteComentById (String id){
        comentRepository.deleteById(id);
    }


}
