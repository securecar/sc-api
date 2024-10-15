package com.securecar.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CidadeTO {
    private int idCidade;
    @NotBlank
    private String nomeCidade;
    @NotNull
    private int idEstado;

    public CidadeTO() {
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
}
