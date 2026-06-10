package com.BoletinVirtual.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoletinVirtual.backend.model.ReporteStrategy;
import com.BoletinVirtual.backend.service.ReporteStrategyService;

@RestController
@RequestMapping("/api")
public class ReporteController {

    private final ReporteStrategyService reporteStrategyService;

    public ReporteController(ReporteStrategyService reporteStrategyService) {
        this.reporteStrategyService = reporteStrategyService;
    }

    @GetMapping("/reporte/alumnos")
    public List<ReporteStrategy> generarReporte() {
        return reporteStrategyService.generar();
    }

    @GetMapping("/reporte/aprobados")
    public List<ReporteStrategy> listarAprobados() {
        return reporteStrategyService.generar()
                .stream()
                .filter(ReporteStrategy::isAprobado)
                .toList();
    }

    @GetMapping("/reporte/desaprobados")
    public List<ReporteStrategy> listarDesaprobados() {
        return reporteStrategyService.generar()
                .stream()
                .filter(r -> !r.isAprobado())
                .toList();
    }
}
