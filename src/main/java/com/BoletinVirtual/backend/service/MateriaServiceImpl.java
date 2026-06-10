package com.BoletinVirtual.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoletinVirtual.backend.model.Materia;
import com.BoletinVirtual.backend.repository.MateriaRepository;

import jakarta.transaction.Transactional;

@Service
public class MateriaServiceImpl implements MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;

    public MateriaServiceImpl(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public List<Materia> listar() {
        return materiaRepository.findAll();

    }

    @Override
    public Materia guardar(Materia entidad) {
        return materiaRepository.save(entidad);
    }

    @Override
    public Materia actualizar(Materia entidad) {
        return materiaRepository.save(entidad);
    }

    @Override
    public void eliminar(Materia entidad) {
        materiaRepository.delete(entidad);
    }

    @Override
    @Transactional
    public void eliminarPorId(Integer id_materia) {
        materiaRepository.deleteById(id_materia);
    }

}
