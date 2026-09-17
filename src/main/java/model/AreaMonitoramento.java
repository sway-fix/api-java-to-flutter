package com.fiap.mecatronica.api_java_to_flutter.model;
public class AreaMonitoramento {
    private Long id;
    private String codigo;
    private String rodovia;
    private Double kmInicial;
    private Double kmFinal;
    private String localizacao;
    private StatusVegetacao status;
    private String tipoTerreno;
    private Double densidade;
    private Double alturaMedia;
    private Integer totalMedicoes;
    public AreaMonitoramento() {
    }
    public AreaMonitoramento(
            Long id,
            String codigo,
            String rodovia,
            Double kmInicial,
            Double kmFinal,
            String localizacao,
            StatusVegetacao status,
            String tipoTerreno,
            Double densidade,
            Double alturaMedia,
            Integer totalMedicoes
    ) {
        this.id = id;
        this.codigo = codigo;
        this.rodovia = rodovia;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.localizacao = localizacao;
        this.status = status;
        this.tipoTerreno = tipoTerreno;
        this.densidade = densidade;
        this.alturaMedia = alturaMedia;
        this.totalMedicoes = totalMedicoes;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getRodovia() { return rodovia; }
    public void setRodovia(String rodovia) { this.rodovia = rodovia; }
    public Double getKmInicial() { return kmInicial; }
    public void setKmInicial(Double kmInicial) { this.kmInicial = kmInicial; }
    public Double getKmFinal() { return kmFinal; }
    public void setKmFinal(Double kmFinal) { this.kmFinal = kmFinal; }
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
    public StatusVegetacao getStatus() { return status; }
    public void setStatus(StatusVegetacao status) { this.status = status; }
    public String getTipoTerreno() { return tipoTerreno; }
    public void setTipoTerreno(String tipoTerreno) { this.tipoTerreno = tipoTerreno; }
    public Double getDensidade() { return densidade; }
    public void setDensidade(Double densidade) { this.densidade = densidade; }
    public Double getAlturaMedia() { return alturaMedia; }
    public void setAlturaMedia(Double alturaMedia) { this.alturaMedia = alturaMedia; }
    public Integer getTotalMedicoes() { return totalMedicoes; }
    public void setTotalMedicoes(Integer totalMedicoes) { this.totalMedicoes = totalMedicoes; }
}