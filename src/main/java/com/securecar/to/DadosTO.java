package com.securecar.to;

import jakarta.validation.constraints.NotNull;

public class DadosTO {
    private int idDados;
    @NotNull
    private int idLogradouro;
    @NotNull
    private int idEmail;
    @NotNull
    private int idTelefone;

    public DadosTO() {
    }

    public int getIdDados() {
        return idDados;
    }

    public void setIdDados(int idDados) {
        this.idDados = idDados;
    }

    public int getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }
}
