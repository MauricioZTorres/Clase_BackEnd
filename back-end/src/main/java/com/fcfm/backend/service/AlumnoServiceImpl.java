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



    private AlumnoRepository alumnoRepository;

    @Autowired
    AlumnoServiceImpl(AlumnoRepository alumnoRepository){
        this.alumnoRepository=alumnoRepository;
    }

    public List<Alumno> getAlumnoList() {
        List<Alumno> alumnoList = new ArrayList<>();
        for (com.fcfm.backend.repository.entity.Alumno alumno : alumnoRepository.getAlumnoList()){
            alumnoList.add(AlumnoMapper.alumnoEntityToAlumnoModel(alumno));
        }
        return alumnoList;
    }

    public void createAlumno(Alumno newAlumno){
        alumnoRepository.insertar(AlumnoMapper.alumnoModelToAlumnoEntity(newAlumno));
    }

    public Alumno getAlumnoByID(int id) {
        com.fcfm.backend.repository.entity.Alumno alumnoEntity = alumnoRepository.getAlumnoById(Long.valueOf(id));
        return AlumnoMapper.alumnoEntityToAlumnoModel(alumnoEntity);
    }

    public void updateAlumno(long id, Alumno infN){
        alumnoRepository.actualizar(id,AlumnoMapper.alumnoModelToAlumnoEntity(infN));
    }

    public void deleteAlumno(long id){
        alumnoRepository.eliminar(id);
    }

}
