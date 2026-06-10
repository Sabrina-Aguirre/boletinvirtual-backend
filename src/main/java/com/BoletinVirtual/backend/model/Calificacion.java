package com.BoletinVirtual.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "calificaciones")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nota;
    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
    @Min(value = 1, message = "La nota mínima es 1")
    @Max(value = 10, message = "La nota máxima es 10")
    private Integer nota;
    private LocalDate fecha;

    public Calificacion() {
    }

    public Calificacion(Integer id_nota, Materia materia, Alumno alumno, Integer nota, LocalDate fecha) {
        this.id_nota = id_nota;
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
        this.fecha = fecha;
    }

    public Integer getId_nota() {
        return id_nota;
    }

    public void setId_nota(Integer id_nota) {
        this.id_nota = id_nota;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
