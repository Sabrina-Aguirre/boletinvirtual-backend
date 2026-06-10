package com.BoletinVirtual.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BoletinVirtual.backend.model.Materia;

@Service
public interface MateriaService {

    List<Materia> listar();

    Materia guardar(Materia entidad);

    Materia actualizar(Materia entidad);

    void eliminar(Materia entidad);

    void eliminarPorId(Integer id_materia);

}
