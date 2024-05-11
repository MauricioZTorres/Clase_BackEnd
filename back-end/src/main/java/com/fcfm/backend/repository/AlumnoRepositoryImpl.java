package com.fcfm.backend.repository;

import com.fcfm.backend.repository.entity.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insertar(Alumno alumno) {
        em.persist(alumno);
    }

    @Override
    public List<Alumno> getAlumnoList() {
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a", Alumno.class);
        return query.getResultList();
    }

    @Override
    public Alumno getAlumnoById(Long id) {
        return em.find(Alumno.class,id);
    }

    @Transactional
    public void actualizar(long id, Alumno alumno) {
        Alumno alumnoExistente = em.find(Alumno.class, id);

        alumnoExistente.setPrimerNombre(alumno.getPrimerNombre());
        alumnoExistente.setSegundoNombre(alumno.getSegundoNombre());

        alumnoExistente.setApellidoPat(alumno.getApellidoPat());
        alumnoExistente.setApellidoMat(alumno.getApellidoMat());

        alumnoExistente.setEmail(alumno.getEmail());
        alumnoExistente.setCurp(alumno.getCurp());
        alumnoExistente.setFechaNac(alumno.getFechaNac());
    }

    @Transactional
    public void eliminar(long id) {
        Alumno alumno = em.find(Alumno.class, id);
        try{
            if (alumno != null){
                em.remove(alumno);
            }

        }
        catch(Exception exception){
             throw new RuntimeException(exception.getMessage());
        }
    }
}
