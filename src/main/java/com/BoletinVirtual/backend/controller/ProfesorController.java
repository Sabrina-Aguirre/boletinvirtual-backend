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

import com.BoletinVirtual.backend.model.Profesor;
import com.BoletinVirtual.backend.service.ProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/profesor")
    public List<Profesor> listar() {
        return profesorService.listar();
    }

    @PostMapping("/profesor")
    public Profesor guardar(@RequestBody Profesor entidad) {
        return profesorService.guardar(entidad);
    }

    @PutMapping("/profesor")
    public Profesor actualizar(@RequestBody Profesor entidad) {
        return profesorService.actualizar(entidad);
    }

    @DeleteMapping("/profesor")
    public void eliminar(@RequestBody Profesor entidad) {
        profesorService.eliminar(entidad);
    }

    @DeleteMapping("/profesor/{idProfesor}")
    public void eliminarPorId(@PathVariable Integer idProfesor) {
        profesorService.eliminarPorId(idProfesor);
    }

}
