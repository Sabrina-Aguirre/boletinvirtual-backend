package com.BoletinVirtual.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BoletinVirtual.backend.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    void deleteByProfesorIdProfesor(Integer idProfesor);
}
