package com.BoletinVirtual.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BoletinVirtual.backend.model.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {
    List<Calificacion> findByAlumnoIdAlumno(Integer idAlumno);

    void deleteByAlumnoIdAlumno(Integer idAlumno);
}
