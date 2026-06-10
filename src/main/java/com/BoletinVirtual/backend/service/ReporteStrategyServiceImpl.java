package com.BoletinVirtual.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.BoletinVirtual.backend.model.Alumno;
import com.BoletinVirtual.backend.model.Calificacion;
import com.BoletinVirtual.backend.model.Materia;
import com.BoletinVirtual.backend.model.ReporteStrategy;
import com.BoletinVirtual.backend.repository.AlumnoRepository;
import com.BoletinVirtual.backend.repository.CalificacionRepository;
import com.BoletinVirtual.backend.repository.MateriaRepository;

@Service
public class ReporteStrategyServiceImpl implements ReporteStrategyService {

    private final AlumnoRepository alumnoRepository;
    private final CalificacionRepository calificacionRepository;
    private final MateriaRepository materiaRepository;

    public ReporteStrategyServiceImpl(AlumnoRepository alumnoRepository,
            CalificacionRepository calificacionRepository,
            MateriaRepository materiaRepository) {
        this.alumnoRepository = alumnoRepository;
        this.calificacionRepository = calificacionRepository;
        this.materiaRepository = materiaRepository;
    }

    @Override
    public List<ReporteStrategy> generar() {
        List<ReporteStrategy> reporte = new ArrayList<>();
        List<Alumno> alumnos = alumnoRepository.findAll();
        List<Materia> materias = materiaRepository.findAll();

        for (Alumno alumno : alumnos) {
            for (Materia materia : materias) {
                List<Calificacion> calificaciones = calificacionRepository
                        .findByAlumnoIdAlumno(alumno.getIdAlumno())
                        .stream()
                        .filter(c -> c.getMateria().getId_materia().equals(materia.getId_materia()))
                        .toList();

                if (!calificaciones.isEmpty()) {
                    double promedio = calificaciones.stream()
                            .mapToInt(Calificacion::getNota)
                            .average()
                            .orElse(0.0);

                    reporte.add(new ReporteStrategy(
                            alumno.getNombre(),
                            alumno.getApellido(),
                            materia.getNombre(),
                            promedio,
                            promedio >= 6));
                }
            }
        }
        return reporte;
    }
}