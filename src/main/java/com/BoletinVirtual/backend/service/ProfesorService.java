package com.BoletinVirtual.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BoletinVirtual.backend.model.Profesor;

@Service
public interface ProfesorService {
    List<Profesor> listar();

    Profesor guardar(Profesor entidad);

    Profesor actualizar(Profesor entidad);

    void eliminar(Profesor entidad);

    void eliminarPorId(Integer idProfesor);
}
