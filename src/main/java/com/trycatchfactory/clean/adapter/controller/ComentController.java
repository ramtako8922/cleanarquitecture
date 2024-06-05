package com.trycatchfactory.clean.adapter.controller;

import com.trycatchfactory.clean.domain.entity.Coment;
import com.trycatchfactory.clean.domain.usecase.ComentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ComentController {

    private  final ComentUseCase comentUseCase;
    public ComentController(ComentUseCase comentUseCase) {
        this.comentUseCase = comentUseCase;
    }

    /**
     * Get coment by id
     * @param id
     * @return
     */
    @GetMapping("coments/{id}")
    public ResponseEntity<Coment> getUserById(@PathVariable String id) {

        Coment coment = comentUseCase.getComentById(id);
        if (coment != null) {
            return new ResponseEntity<>(coment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Save coment
     * @param coment
     * @return
     */
    @PostMapping("/coments")
    public ResponseEntity<Void> createComent(@RequestBody Coment coment){
        comentUseCase.execute(coment);

        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
}
