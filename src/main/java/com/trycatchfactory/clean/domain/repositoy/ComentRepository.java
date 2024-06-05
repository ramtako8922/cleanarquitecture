package com.trycatchfactory.clean.domain.repositoy;

import com.trycatchfactory.clean.domain.entity.Coment;

public interface ComentRepository {

    public void save(Coment coment);

    public Coment findById(String id);
}
