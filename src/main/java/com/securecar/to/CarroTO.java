package com.securecar.to;

import jakarta.validation.constraints.*;
import jakarta.ws.rs.DefaultValue;

import java.time.Year;

public class CarroTO {
    private Long idCarro;
    @NotNull(message = "Modelo não pode estar vazio!")
    private String modelo;

    private int ano;
    @NotBlank(message = "Placa tem que estar preenchida!")
    private String placa;
    @NotBlank(message = "Chassi tem que estar preenchido!")
    private String chassi;
    @PositiveOrZero(message = "Quilometragem não pode ser negativa!")
    private Double quilometragem;
    @NotNull(message = "O carro tem que pertencer a um usuário!")
    private Long idUsuario;
//    @Null(message = "Você não precisa ter seguro para ter um carro!")

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


}
