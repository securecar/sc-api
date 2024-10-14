package com.securecar.to;

public class PecaTO {
    private Long idPeca;
    private double valorPeca;
    private String descricaoPeca;
    private int quantidadePeca;

    public PecaTO() {
    }

    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }

    public double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(double valorPeca) {
        this.valorPeca = valorPeca;
    }

    public String getDescricaoPeca() {
        return descricaoPeca;
    }

    public void setDescricaoPeca(String descricaoPeca) {
        this.descricaoPeca = descricaoPeca;
    }

    public int getQuantidadePeca() {
        return quantidadePeca;
    }

    public void setQuantidadePeca(int quantidadePeca) {
        this.quantidadePeca = quantidadePeca;
    }
}

