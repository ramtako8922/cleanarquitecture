package com.trycatchfactory.clean.domain.repositoy;

import com.trycatchfactory.clean.domain.entity.Coment;

import java.util.List;

public interface ComentRepository {
 public List<Coment> findAll();
    public void save(Coment coment);

    public Coment findById(Long id);



    public void update(Long id, Coment coment);

    public void deleteById(Long id );
}
