package com.fiap.mecatronica.api_java_to_flutter.model;
import com.fasterxml.jackson.annotation.JsonValue;
public enum StatusVegetacao {
    NORMAL("normal"),
    ATENCAO("atencao"),
    URGENTE("urgente");
    private final String valor;
    StatusVegetacao(String valor) {
        this.valor = valor;
    }
    @JsonValue
    public String getValor() {
        return valor;
    }
}