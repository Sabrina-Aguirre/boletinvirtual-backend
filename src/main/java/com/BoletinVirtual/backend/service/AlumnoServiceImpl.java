package com.BoletinVirtual.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoletinVirtual.backend.model.Alumno;
import com.BoletinVirtual.backend.model.Calificacion;
import com.BoletinVirtual.backend.repository.AlumnoRepository;
import com.BoletinVirtual.backend.repository.CalificacionRepository;

import jakarta.transaction.Transactional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CalificacionRepository calificacionRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, CalificacionRepository calificacionRepository) {
        this.alumnoRepository = alumnoRepository;
        this.calificacionRepository = calificacionRepository;
    }

    @Override
    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno obtenerPorId(Integer idAlumno) {
        return alumnoRepository.findById(idAlumno).orElse(null);
    }

    @Override
    public Alumno guardar(Alumno entidad) {
        return alumnoRepository.save(entidad);
    }

    @Override
    public Alumno actualizar(Alumno entidad) {
        return alumnoRepository.save(entidad);
    }

    @Override
    public void eliminar(Alumno entidad) {
        alumnoRepository.delete(entidad);
    }

    @Override
    @Transactional
    public void eliminarPorId(Integer idAlumno) {
        calificacionRepository.deleteByAlumnoIdAlumno(idAlumno);
        alumnoRepository.deleteById(idAlumno);
    }

    @Override
    public List<Alumno> listarAprobados() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream()
                .filter(alumno -> {
                    List<Calificacion> calificaciones = calificacionRepository
                            .findByAlumnoIdAlumno(alumno.getIdAlumno());
                    if (calificaciones.isEmpty())
                        return false;
                    double promedio = calificaciones.stream()
                            .mapToInt(Calificacion::getNota)
                            .average()
                            .orElse(0.0);
                    return promedio >= 6;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Alumno> listarDesaprobados() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream()
                .filter(alumno -> {
                    List<Calificacion> calificaciones = calificacionRepository
                            .findByAlumnoIdAlumno(alumno.getIdAlumno());
                    if (calificaciones.isEmpty())
                        return true;
                    double promedio = calificaciones.stream()
                            .mapToInt(Calificacion::getNota)
                            .average()
                            .orElse(0.0);
                    return promedio < 6;
                })
                .collect(Collectors.toList());
    }

}
