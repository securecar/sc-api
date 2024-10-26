package com.securecar.to;

public class SeguroTO {
    private Long idSeguro;
    private Long cnpj;
    private String nomeSeguro;
    private int incriscaoEstadual;

    public SeguroTO() {
    }

    public Long getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Long idSeguro) {
        this.idSeguro = idSeguro;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeSeguro() {
        return nomeSeguro;
    }

    public void setNomeSeguro(String nomeSeguro) {
        this.nomeSeguro = nomeSeguro;
    }

    public int getIncriscaoEstadual() {
        return incriscaoEstadual;
    }

    public void setIncriscaoEstadual(int incriscaoEstadual) {
        this.incriscaoEstadual = incriscaoEstadual;
    }

}
