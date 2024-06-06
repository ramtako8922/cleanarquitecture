package com.trycatchfactory.clean.domain.repositoy;

import com.trycatchfactory.clean.domain.entity.Coment;

import java.util.List;

public interface ComentRepository {
 public List<Coment> findAll();
    public void save(Coment coment);

    public Coment findById(String id);

    public void update(String id ,Coment coment);

    public void deleteById(String id );
}
