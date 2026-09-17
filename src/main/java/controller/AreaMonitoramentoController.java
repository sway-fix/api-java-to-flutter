package com.fiap.mecatronica.api_java_to_flutter.controller;

import com.fiap.mecatronica.api_java_to_flutter.model.AreaMonitoramento;
import com.fiap.mecatronica.api_java_to_flutter.model.ResumoAreas;
import com.fiap.mecatronica.api_java_to_flutter.service.AreaMonitoramentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/areas")
@CrossOrigin(origins = "*")
public class AreaMonitoramentoController {

    private final AreaMonitoramentoService service;

    public AreaMonitoramentoController(AreaMonitoramentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AreaMonitoramento> listar() {
        return service.listarTodas();
    }

    @GetMapping("/resumo")
    public ResumoAreas resumo() {
        return service.obterResumo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaMonitoramento> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/coleta")
    public List<AreaMonitoramento> simularColetaEmTodas() {
        return service.simularColetaEmTodas();
    }

    @PostMapping("/{id}/coleta")
    public ResponseEntity<AreaMonitoramento> simularColeta(@PathVariable Long id) {
        return service.simularColeta(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}