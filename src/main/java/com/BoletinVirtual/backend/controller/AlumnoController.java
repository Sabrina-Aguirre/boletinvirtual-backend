
package com.BoletinVirtual.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoletinVirtual.backend.model.Alumno;
import com.BoletinVirtual.backend.service.AlumnoService;

@RestController
@RequestMapping("/api")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/alumno")
    public List<Alumno> listar() {
        return alumnoService.listar();
    }

    @GetMapping("/alumno/{idAlumno}")
    public Alumno obtenerPorId(@PathVariable Integer idAlumno) {
        return alumnoService.obtenerPorId(idAlumno);
    }

    @PostMapping("/alumno")
    public Alumno guardar(@RequestBody Alumno entidad) {
        return alumnoService.guardar(entidad);
    }

    @PutMapping("/alumno")
    public Alumno actualizar(@RequestBody Alumno entidad) {
        return alumnoService.actualizar(entidad);
    }

    @DeleteMapping("/alumno")
    public void eliminar(@RequestBody Alumno entidad) {
        alumnoService.eliminar(entidad);
    }

    @DeleteMapping("/alumno/{idAlumno}")
    public void eliminarPorId(@PathVariable Integer idAlumno) {
        alumnoService.eliminarPorId(idAlumno);
    }

}
