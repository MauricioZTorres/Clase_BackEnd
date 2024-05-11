package com.fcfm.backend.utils;

import com.fcfm.backend.repository.entity.Alumno;
import java.sql.Date;

public class AlumnoMapper {
    public static com.fcfm.backend.model.Alumno alumnoEntityToAlumnoModel(Alumno alumno){
        com.fcfm.backend.model.Alumno model = new com.fcfm.backend.model.Alumno();
        model.setPrimerNombre(alumno.getPrimerNombre());
        model.setSegundoNombre(alumno.getSegundoNombre());
        model.setApellidoPat(alumno.getApellidoPat());
        model.setApellidoMat(alumno.getApellidoMat());
        model.setFechaNac(alumno.getFechaNac().toString());
        model.setCurp(alumno.getCurp());
        model.setEmail(alumno.getEmail());
        return model;
    }

    public static Alumno alumnoModelToAlumnoEntity(com.fcfm.backend.model.Alumno alumno){
        Alumno entity = new com.fcfm.backend.repository.entity.Alumno();
        entity.setPrimerNombre(alumno.getPrimerNombre());
        entity.setSegundoNombre(alumno.getSegundoNombre());
        entity.setApellidoPat(alumno.getApellidoPat());
        entity.setApellidoMat(alumno.getApellidoMat());
        entity.setCurp(alumno.getCurp());
        entity.setEmail(alumno.getEmail());
        entity.setFechaNac(Date.valueOf(alumno.getFechaNac()));
        return entity;
    }
}
