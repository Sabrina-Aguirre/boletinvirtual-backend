package com.BoletinVirtual.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BoletinVirtual.backend.model.Alumno;

@Service
public interface AlumnoService {

    List<Alumno> listar();

    Alumno obtenerPorId(Integer idAlumno);

    Alumno guardar(Alumno entidad);

    Alumno actualizar(Alumno entidad);

    void eliminar(Alumno entidad);

    void eliminarPorId(Integer idAlumno);

    List<Alumno> listarAprobados();

    List<Alumno> listarDesaprobados();
}
