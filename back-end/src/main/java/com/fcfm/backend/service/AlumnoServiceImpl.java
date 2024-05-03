package com.fcfm.backend.service;

import com.fcfm.backend.model.Alumno;
import com.fcfm.backend.repository.AlumnoRepository;
import com.fcfm.backend.utils.AlumnoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    List<Alumno> alumnoList = new ArrayList<>();

    private AlumnoRepository alumnoRepository;

    @Autowired
    AlumnoServiceImpl(AlumnoRepository alumnoRepository){
        this.alumnoRepository=alumnoRepository;
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void createAlumno(Alumno newAlumno){
        alumnoRepository.insertar(AlumnoMapper.alumnoModelToAlumnoEntity(newAlumno));
    }

    public Alumno getAlumnoByID(int id) {
        com.fcfm.backend.repository.entity.Alumno alumnoEntity = alumnoRepository.getAlumnoById(Long.valueOf(id));
        return AlumnoMapper.alumnoEntityToAlumnoModel(alumnoEntity);
    }

    public void updateAlumno(int id, Alumno infN){
        alumnoList.set(id,infN);
    }

    public void deleteAlumno(int id){
        alumnoList.remove(id);
    }

}
