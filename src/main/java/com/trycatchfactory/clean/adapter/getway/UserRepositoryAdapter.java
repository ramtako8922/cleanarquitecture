package com.trycatchfactory.clean.adapter.getway;

import com.trycatchfactory.clean.domain.entity.Coment;
import com.trycatchfactory.clean.domain.repositoy.ComentRepository;
import com.trycatchfactory.clean.infraestructure.persistence.ComentEntity;
import com.trycatchfactory.clean.infraestructure.persistence.SpringDataComentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepositoryAdapter implements ComentRepository {

    private final SpringDataComentRepository springDataUserRepository;

    @Autowired
    public UserRepositoryAdapter(SpringDataComentRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }
    @Override
    public Coment findById(String id){
      ComentEntity comentEntity=springDataUserRepository.findById(id).orElse(null);
         if(comentEntity!=null){

          Coment coment=new Coment();
           coment.setId(comentEntity.getId());
           coment.setTitle(comentEntity.getTitle());
           coment.setContent(comentEntity.getContent());

             return coment;
         }
       return null;
    }
    @Override
    public void save(Coment coment) {

        ComentEntity comentEntity=new ComentEntity();
        comentEntity.setId(coment.getId());
        comentEntity.setTitle(coment.getTitle());
        comentEntity.setContent(coment.getContent());

        springDataUserRepository.save(comentEntity);

    }
}
