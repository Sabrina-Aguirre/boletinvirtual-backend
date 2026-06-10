package com.BoletinVirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.BoletinVirtual.backend.model.Materia;
import com.BoletinVirtual.backend.service.MateriaService;

@RestController
@RequestMapping("/api")
public class MateriaController {
    @Autowired
    private MateriaService materiaService;

    @GetMapping("/materia")
    public List<Materia> listar() {
        return materiaService.listar();
    }

    @PostMapping("/materia")
    public Materia guardar(@RequestBody Materia entidad) {
        return materiaService.guardar(entidad);
    }

    @PutMapping("/materia")
    public Materia actualizar(@RequestBody Materia entidad) {
        return materiaService.actualizar(entidad);
    }

    @DeleteMapping("/materia")
    public void eliminar(@RequestBody Materia entidad) {
        materiaService.eliminar(entidad);
    }

    @DeleteMapping("/materia/{id_materia}")
    public void eliminarPorId(@PathVariable Integer id_materia) {
        materiaService.eliminarPorId(id_materia);
    }

}
