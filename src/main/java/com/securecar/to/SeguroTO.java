package com.securecar.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public class SeguroTO {
    private Long idSeguro;
    @CNPJ(message = "CNPJ inválido, faz o L")
    private String cnpj;
    @NotBlank(message = "Seguro tem que ter nome.")
    private String nomeSeguro;

    @NotNull(message = "Seguro tem que ter inscrição estadual")
    private String inscricaoEstadual;

    public SeguroTO() {
    }

    public Long getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Long idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeSeguro() {
        return nomeSeguro;
    }

    public void setNomeSeguro(String nomeSeguro) {
        this.nomeSeguro = nomeSeguro;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}