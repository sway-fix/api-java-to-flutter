package com.fiap.mecatronica.api_java_to_flutter.model;

public class ResumoAreas {

    private int total;
    private int normal;
    private int atencao;
    private int urgente;

    public ResumoAreas() {
    }

    public ResumoAreas(int total, int normal, int atencao, int urgente) {
        this.total = total;
        this.normal = normal;
        this.atencao = atencao;
        this.urgente = urgente;
    }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public int getNormal() { return normal; }
    public void setNormal(int normal) { this.normal = normal; }

    public int getAtencao() { return atencao; }
    public void setAtencao(int atencao) { this.atencao = atencao; }

    public int getUrgente() { return urgente; }
    public void setUrgente(int urgente) { this.urgente = urgente; }
}