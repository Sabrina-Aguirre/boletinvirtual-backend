package com.BoletinVirtual.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoletinVirtual.backend.model.Alumno;
import com.BoletinVirtual.backend.model.Calificacion;
import com.BoletinVirtual.backend.service.CalificacionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/calificacion")
    public List<Calificacion> listar() {
        return calificacionService.listar();
    }

    @PostMapping("/calificacion")
    public Calificacion guardar(@RequestBody Calificacion entidad) {
        return calificacionService.guardar(entidad);
    }

    @PutMapping("/calificacion")
    public Calificacion actualizar(@RequestBody Calificacion entidad) {
        return calificacionService.actualizar(entidad);
    }

    @DeleteMapping("/calificacion")
    public void eliminar(@RequestBody Calificacion entidad) {
        calificacionService.eliminar(entidad);
    }

    @DeleteMapping("/calificacion/{id_nota}")
    public void eliminarPorId(@PathVariable Integer id_nota) {
        calificacionService.eliminarPorId(id_nota);
    }

    @GetMapping("/calificacion/promedio/{idAlumno}")
    public Double calcularPromedio(@PathVariable Integer idAlumno) {
        return calificacionService.calcularPromedio(idAlumno);
    }

    @GetMapping("/calificacion/alumno/{idAlumno}")
    public List<Calificacion> listarPorAlumno(@PathVariable Integer idAlumno) {
        return calificacionService.listarPorAlumno(idAlumno);
    }

    @GetMapping("/calificacion/aprobados")
    public List<Alumno> listarAprobados() {
        return calificacionService.listarAprobados();
    }

    @GetMapping("/calificacion/desaprobados")
    public List<Alumno> listarDesaprobados() {
        return calificacionService.listarDesaprobados();
    }

}
