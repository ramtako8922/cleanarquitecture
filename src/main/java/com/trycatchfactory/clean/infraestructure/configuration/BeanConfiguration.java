package com.trycatchfactory.clean.infraestructure.configuration;

import com.trycatchfactory.clean.domain.repositoy.ComentRepository;
import com.trycatchfactory.clean.domain.usecase.ComentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
@Bean
    public ComentUseCase createComentUseCase(ComentRepository comentRepository){

    return new ComentUseCase(comentRepository);
}
}
