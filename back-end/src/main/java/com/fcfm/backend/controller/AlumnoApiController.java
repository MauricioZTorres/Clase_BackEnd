package com.fcfm.backend.controller;

import com.fcfm.backend.model.Alumno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/alumno")
public interface AlumnoApiController {

    @PostMapping("/")
    ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumnoNuevo);

    @GetMapping("/")
    ResponseEntity<List<Alumno>> getAlumnoList();

    @GetMapping("/{idAlumno}")
    ResponseEntity<Alumno> getAlumnoById(@PathVariable int idAlumno);

    /*UPDATE ALUMNO*/
    @PutMapping("/{idAlumno}")
    ResponseEntity<Alumno> updateAlumno(@PathVariable int idAlumno, @RequestBody Alumno alumnoUpdate);

    /*DELETE ALUMNO*/
    @DeleteMapping("/{idAlumno}")
    ResponseEntity<Alumno> deleteAlumno(@PathVariable int idAlumno);
}
