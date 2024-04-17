package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.AlumnoApiController;
import com.fcfm.backend.model.Alumno;
import com.fcfm.backend.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Alumno>> getAlumnoList() {
        return ResponseEntity.ok().body(alumnoService.getAlumnoList());
    }

    @Override
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable int idAlumno) {
        return ResponseEntity.ok().body(alumnoService.getAlumnoByID(idAlumno));
    }

    @Override
    public ResponseEntity<Alumno> updateAlumno(@PathVariable int idAlumno, @RequestBody Alumno alumnoUpdate){
        List<Alumno> alumnoList0 = alumnoService.getAlumnoList();
        if (idAlumno >= alumnoList0.size()){
            return ResponseEntity.notFound().build();
        }
        else {
            alumnoService.updateAlumno(idAlumno, alumnoUpdate);
            return ResponseEntity.ok().body(alumnoUpdate);
        }
    }

    @Override
    public ResponseEntity<Alumno> deleteAlumno(@PathVariable int idAlumno){
        List<Alumno> alumnoList0 = alumnoService.getAlumnoList();
        if (idAlumno >= alumnoList0.size()){
            return ResponseEntity.notFound().build();
        }
        else {
            alumnoService.deleteAlumno(idAlumno);
            return ResponseEntity.ok().body(alumnoService.getAlumnoByID(idAlumno));
        }

    }

}
