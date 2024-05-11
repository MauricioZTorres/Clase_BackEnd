package com.fcfm.backend.controller;

import com.fcfm.backend.model.Alumno;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/alumno")
public interface AlumnoApiController {

    @PostMapping("/")
    ResponseEntity<?> createAlumno(@Valid @RequestBody Alumno alumnoNuevo);

    @GetMapping("/")
    ResponseEntity<?> getAlumnoList();

    @GetMapping("/{idAlumno}")
    ResponseEntity<?> getAlumnoById(@PathVariable int idAlumno);

    /*UPDATE ALUMNO*/
    @PutMapping("/{idAlumno}")
    //ResponseEntity<Alumno> updateAlumno(@PathVariable int idAlumno, @RequestBody Alumno alumnoUpdate);
    ResponseEntity<String> updateAlumno(@Valid @PathVariable int idAlumno, @RequestBody Alumno alumnoUpdate);

    /*DELETE ALUMNO*/
    @DeleteMapping("/{idAlumno}")
    ResponseEntity<String> deleteAlumno(@PathVariable int idAlumno);
}
