package com.fiap.mecatronica.api_java_to_flutter.service;

import com.fiap.mecatronica.api_java_to_flutter.model.AreaMonitoramento;
import com.fiap.mecatronica.api_java_to_flutter.model.ResumoAreas;
import com.fiap.mecatronica.api_java_to_flutter.model.StatusVegetacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AreaMonitoramentoService {

    private final List<AreaMonitoramento> areas = new ArrayList<>();

    public AreaMonitoramentoService() {
        areas.add(new AreaMonitoramento(
                1L, "SP280-KM120", "SP-280", 120.0, 125.0,
                "Sorocaba / SP", StatusVegetacao.NORMAL, "Planície",
                0.42, 1.10, 8
        ));
        areas.add(new AreaMonitoramento(
                2L, "BR116-KM045", "BR-116", 45.0, 50.0,
                "Registro / SP", StatusVegetacao.ATENCAO, "Encosta",
                0.71, 1.85, 12
        ));
        areas.add(new AreaMonitoramento(
                3L, "SP330-KM210", "SP-330", 210.0, 214.0,
                "Campinas / SP", StatusVegetacao.URGENTE, "Vale",
                0.91, 2.40, 20
        ));
        areas.add(new AreaMonitoramento(
                4L, "BR381-KM065", "BR-381", 65.0, 70.0,
                "Mairiporã / SP", StatusVegetacao.URGENTE, "Serra / Encosta",
                0.85, 2.30, 18
        ));
    }

    public List<AreaMonitoramento> listarTodas() {
        return areas;
    }

    public Optional<AreaMonitoramento> buscarPorId(Long id) {
        return areas.stream()
                .filter(area -> area.getId().equals(id))
                .findFirst();
    }

    public ResumoAreas obterResumo() {
        int normal = contarPorStatus(StatusVegetacao.NORMAL);
        int atencao = contarPorStatus(StatusVegetacao.ATENCAO);
        int urgente = contarPorStatus(StatusVegetacao.URGENTE);
        return new ResumoAreas(areas.size(), normal, atencao, urgente);
    }

    public Optional<AreaMonitoramento> simularColeta(Long id) {
        Optional<AreaMonitoramento> encontrada = buscarPorId(id);
        encontrada.ifPresent(this::aplicarNovaMedicao);
        return encontrada;
    }

    public List<AreaMonitoramento> simularColetaEmTodas() {
        areas.forEach(this::aplicarNovaMedicao);
        return areas;
    }

    private int contarPorStatus(StatusVegetacao status) {
        return (int) areas.stream()
                .filter(area -> area.getStatus() == status)
                .count();
    }

    private void aplicarNovaMedicao(AreaMonitoramento area) {
        double novaDensidade = Math.min(1.0, area.getDensidade() + 0.05);
        double novaAltura = area.getAlturaMedia() + 0.08;

        area.setDensidade(arredondar(novaDensidade));
        area.setAlturaMedia(arredondar(novaAltura));
        area.setTotalMedicoes(area.getTotalMedicoes() + 1);
        area.setStatus(classificarStatus(novaDensidade));
    }

    private StatusVegetacao classificarStatus(double densidade) {
        if (densidade < 0.55) {
            return StatusVegetacao.NORMAL;
        }
        if (densidade < 0.80) {
            return StatusVegetacao.ATENCAO;
        }
        return StatusVegetacao.URGENTE;
    }

    private double arredondar(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}