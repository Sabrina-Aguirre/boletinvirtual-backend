package com.BoletinVirtual.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoletinVirtual.backend.model.Profesor;
import com.BoletinVirtual.backend.repository.MateriaRepository;
import com.BoletinVirtual.backend.repository.ProfesorRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<Profesor> listar() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor guardar(Profesor entidad) {
        return profesorRepository.save(entidad);
    }

    @Override
    public Profesor actualizar(Profesor entidad) {
        return profesorRepository.save(entidad);
    }

    @Override
    public void eliminar(Profesor entidad) {
        profesorRepository.delete(entidad);
    }

    @Override
    @Transactional
    public void eliminarPorId(Integer idProfesor) {
        materiaRepository.deleteByProfesorIdProfesor(idProfesor);
        profesorRepository.deleteById(idProfesor);
    }
}