package com.BoletinVirtual.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BoletinVirtual.backend.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}