package com.trycatchfactory.clean.adapter.controller;

import com.trycatchfactory.clean.adapter.presenter.ComentPresenter;
import com.trycatchfactory.clean.adapter.presenter.ComentResponseDTO;
import com.trycatchfactory.clean.domain.entity.Coment;
import com.trycatchfactory.clean.domain.usecase.ComentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ComentController {

    private  final ComentUseCase comentUseCase;
    private  final ComentPresenter comentPresenter;

    /**
     * Constructor Method
     * @param comentUseCase
     * @param comentPresenter
     */
    public ComentController(ComentUseCase comentUseCase, ComentPresenter comentPresenter) {
        this.comentUseCase = comentUseCase;
        this.comentPresenter = comentPresenter;
    }

    /**
     * Get coment by id
     * @param id
     * @return
     */
    @GetMapping("coments/{id}")
    public ResponseEntity<ComentResponseDTO> getUserById(@PathVariable String id) {

        Coment coment = comentUseCase.getComentById(id);
        return  comentPresenter.present(coment);
    }

    /**
     * Save coment
     * @param coment
     * @return
     */
    @PostMapping("/coments")
    public ResponseEntity<Void> createComent(@RequestBody Coment coment){
        comentUseCase.execute(coment);

        return  comentPresenter.PresenterCreateComent();
    }
}
