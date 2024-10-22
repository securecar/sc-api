package com.securecar.to;

import jakarta.validation.constraints.NotNull;

public class DadosTO {
    private Long idDados;
    @NotNull
    private Long idLogradouro;
    @NotNull
    private Long idEmail;
    @NotNull
    private Long idTelefone;

    public DadosTO() {
    }

    public Long getIdDados() {
        return idDados;
    }

    public void setIdDados(Long idDados) {
        this.idDados = idDados;
    }

    public Long getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Long idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public Long getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Long idEmail) {
        this.idEmail = idEmail;
    }

    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }
}
