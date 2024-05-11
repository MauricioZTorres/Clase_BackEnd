package com.fcfm.backend.service;

import com.fcfm.backend.model.Alumno;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlumnoService {
    List<Alumno> getAlumnoList();

    void createAlumno(Alumno newAlumno);

    Alumno getAlumnoByID(int id);

    void updateAlumno(long id, Alumno infN);

    void deleteAlumno(long id);
}
