package com.trycatchfactory.clean.adapter.controller;

import com.trycatchfactory.clean.adapter.presenter.ComentPresenter;
import com.trycatchfactory.clean.adapter.presenter.ComentResponseDTO;
import com.trycatchfactory.clean.domain.entity.Coment;
import com.trycatchfactory.clean.domain.usecase.ComentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/coments")
    public ResponseEntity<List<ComentResponseDTO>> getAllUsers() {
        List<Coment> comentList = comentUseCase.getAllComents();
        return comentPresenter.presentAllComents(comentList);
    }
    /**
     * Get coment by id
     * @param id
     * @return
     */
    @GetMapping("coments/{id}")
    public ResponseEntity<ComentResponseDTO> getUserById(@PathVariable Long id) {

        Coment coment = comentUseCase.getComentById(id);
        return  comentPresenter.present(coment);
    }

    /**
     * Save coment restcontroller
     * @param coment
     * @return
     */
    @PostMapping("/coments")
    public ResponseEntity<Void> createComent(@RequestBody Coment coment){
        comentUseCase.saveComent(coment);

        return  comentPresenter.PresenterCreateComent();
    }

    /**
     * Update comment api restcontroller
     * @param id
     * @param coment
     * @return
     */
    @PutMapping("coments/{id}")
    public ResponseEntity<Void> updateComent(@PathVariable Long id, @RequestBody Coment coment){
        comentUseCase.updateComent(id,coment);
        boolean returnContent=true;
        return comentPresenter.presenterUpdateComent(returnContent);
    }

    /**
     * Delete comment by id restcontroller
     * @param id
     * @return
     */
    @DeleteMapping("coments/{id}")
    public ResponseEntity<Void> deleteComentById(@PathVariable Long id){
        comentUseCase.deleteComentById(id);
        boolean returnContent=true;
        return comentPresenter.presenterdeleteByIdComent(returnContent);
    }
}
