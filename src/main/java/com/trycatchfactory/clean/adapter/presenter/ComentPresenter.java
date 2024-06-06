package com.trycatchfactory.clean.adapter.presenter;

import com.trycatchfactory.clean.domain.entity.Coment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ComentPresenter {
    /**
     * response by comment found
     * @param coment
     * @return
     */
    public ResponseEntity<ComentResponseDTO> present(Coment coment){
        if(coment==null){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ComentResponseDTO comentResponseDTO=new ComentResponseDTO(coment.getId(),coment.getTitle(),coment.getContent());
        return  new ResponseEntity<>(comentResponseDTO,HttpStatus.OK);
    }

    /**
     * Response create coment
     *
     * @return
     */
    public  ResponseEntity<Void> PresenterCreateComent(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
