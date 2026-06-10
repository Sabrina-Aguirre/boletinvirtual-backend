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
public class CalificacionServiceImpl implements CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;

    public CalificacionServiceImpl(CalificacionRepository calificacionRepository, AlumnoRepository alumnoRepository) {
        this.calificacionRepository = calificacionRepository;
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<Calificacion> listar() {
        return calificacionRepository.findAll();

    }

    @Override
    public Calificacion guardar(Calificacion entidad) {
        return calificacionRepository.save(entidad);

    }

    @Override
    public Calificacion actualizar(Calificacion entidad) {
        return calificacionRepository.save(entidad);

    }

    @Override
    public void eliminar(Calificacion entidad) {
        calificacionRepository.delete(entidad);
    }

    @Override
    @Transactional
    public void eliminarPorId(Integer id_nota) {
        calificacionRepository.deleteById(id_nota);

    }

    @Override
    public Double calcularPromedio(Integer idAlumno) {
        List<Calificacion> calificaciones = calificacionRepository.findByAlumnoIdAlumno(idAlumno);

        if (calificaciones.isEmpty()) {
            return 0.0;
        }

        return calificaciones.stream()
                .mapToInt(Calificacion::getNota)
                .average()
                .orElse(0.0);
    }

    @Override
    public List<Calificacion> listarPorAlumno(Integer idAlumno) {
        return calificacionRepository.findByAlumnoIdAlumno(idAlumno);
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
