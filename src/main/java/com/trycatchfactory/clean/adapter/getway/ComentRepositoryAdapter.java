package com.trycatchfactory.clean.adapter.getway;

import com.trycatchfactory.clean.domain.entity.Coment;
import com.trycatchfactory.clean.domain.repositoy.ComentRepository;
import com.trycatchfactory.clean.infraestructure.persistence.ComentEntity;
import com.trycatchfactory.clean.infraestructure.persistence.SpringDataComentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ComentRepositoryAdapter implements ComentRepository {

    private final SpringDataComentRepository springDataUserRepository;

    /**
     * Constructor Method and injected dependendencies
     *
     * @param springDataUserRepository
     */
    @Autowired
    public ComentRepositoryAdapter(SpringDataComentRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public List<Coment> findAll() {
        List<ComentEntity> comentEntities= (List<ComentEntity>) springDataUserRepository.findAll();
        return comentEntities.stream().map(comentEntity ->
         new Coment(comentEntity.getId(),comentEntity.getTitle(),comentEntity.getContent())).collect(Collectors.toList());


    }

    /**
     * find comment by id in adapter leavel
     *
     * @param id
     * @return
     */
    @Override
    public Coment findById(Long id) {
        ComentEntity comentEntity = springDataUserRepository.findById(id).orElse(null);
        if (comentEntity != null) {

            Coment coment = new Coment();
            coment.setId(comentEntity.getId());
            coment.setTitle(comentEntity.getTitle());
            coment.setContent(comentEntity.getContent());

            return coment;
        }
        return null;
    }


    /**
     * Save the coment in adapter leavel
     *
     * @param coment
     */
    @Override
    public void save(Coment coment) {

        ComentEntity comentEntity = new ComentEntity();
        comentEntity.setId(coment.getId());
        comentEntity.setTitle(coment.getTitle());
        comentEntity.setContent(coment.getContent());

        springDataUserRepository.save(comentEntity);

    }

    @Override
    public void update(Long id, Coment coment) {
        ComentEntity comentEntity = springDataUserRepository.findById(id).orElse(null);
        if (comentEntity != null) {



            comentEntity.setTitle(coment.getTitle());
            comentEntity.setContent(coment.getContent());

            springDataUserRepository.save(comentEntity);


        }

    }

    /**
     * Delte comment in adaprte level
     *
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        springDataUserRepository.deleteById(id);
    }


}
