package com.securecar.to;

public class CarroTO {
    private Long idCarro;
    private String modelo;
    private int ano;
    private String placa;
    private String chassi;
    private Double quilometragem;
    private Long idUsuario;
    private Long idCarroSeguro;

    public CarroTO() {
    }

    public Long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Long idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdCarroSeguro() {
        return idCarroSeguro;
    }

    public void setIdCarroSeguro(Long idCarroSeguro) {
        this.idCarroSeguro = idCarroSeguro;
    }
}
