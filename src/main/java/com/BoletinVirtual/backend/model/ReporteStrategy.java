package com.BoletinVirtual.backend.model;

public class ReporteStrategy {
    private String nombreAlumno;
    private String apellidoAlumno;
    private String materia;
    private Double promedio;
    private boolean aprobado;

    public ReporteStrategy(String nombreAlumno, String apellidoAlumno, String materia, Double promedio,
            boolean aprobado) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.materia = materia;
        this.promedio = promedio;
        this.aprobado = aprobado;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public String getMateria() {
        return materia;
    }

    public Double getPromedio() {
        return promedio;
    }

    public boolean isAprobado() {
        return aprobado;
    }
}