package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.AlumnoApiController;
import com.fcfm.backend.model.Alumno;
import com.fcfm.backend.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlumnoApiControllerImpl implements AlumnoApiController {

    private AlumnoService alumnoService;

    @Autowired
    AlumnoApiControllerImpl(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @Override
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumnoNuevo){
        alumnoService.createAlumno(alumnoNuevo);
        return ResponseEntity.ok().body(alumnoNuevo);
    }

    @Override
    public ResponseEntity<?> getAlumnoList() {
        try {
            return ResponseEntity.ok().body(alumnoService.getAlumnoList());
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getAlumnoById(@PathVariable int idAlumno) {
        try{
            return ResponseEntity.ok().body(alumnoService.getAlumnoByID(idAlumno));
        } catch (Exception ex){
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El alumno no existe");
        }

    }

    @Override
    public ResponseEntity<String> updateAlumno(@PathVariable int idAlumno, @RequestBody Alumno alumnoUpdate){
        try{
            alumnoService.updateAlumno(idAlumno, alumnoUpdate);
            //return ResponseEntity.ok().body(alumnoUpdate);
            return ResponseEntity.ok().body("Alumno actualizado con éxtio");
        }
        catch(Exception exception){
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El alumno no existe");

        }
    }

    @Override
    public ResponseEntity<String> deleteAlumno(@PathVariable int idAlumno){
        try{
            alumnoService.deleteAlumno(idAlumno);
            return ResponseEntity.ok().body("Alumno eliminado con éxtio");
        }
        catch(Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

}
