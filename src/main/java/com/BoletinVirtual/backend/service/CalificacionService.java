package com.BoletinVirtual.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BoletinVirtual.backend.model.Alumno;
import com.BoletinVirtual.backend.model.Calificacion;

@Service
public interface CalificacionService {

    List<Calificacion> listar();

    Calificacion guardar(Calificacion entidad);

    Calificacion actualizar(Calificacion entidad);

    void eliminar(Calificacion entidad);

    void eliminarPorId(Integer id_nota);

    Double calcularPromedio(Integer idAlumno);

    List<Calificacion> listarPorAlumno(Integer idAlumno);

    List<Alumno> listarAprobados();

    List<Alumno> listarDesaprobados();

}
