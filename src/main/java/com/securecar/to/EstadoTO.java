package com.securecar.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstadoTO {
    private int idEstado;
    @NotBlank
    private String nomeEstado;
    @NotNull
    private int idPais;

    public EstadoTO() {
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
}
