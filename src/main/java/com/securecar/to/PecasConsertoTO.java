package com.securecar.to;

public class PecasConsertoTO {
    private Long idPeca;
    private double valorPeca;
    private String descPeca;
    private int quantidadePeca;
    private Long idConserto;

    public PecasConsertoTO() {
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

    public String getDescPeca() {
        return descPeca;
    }

    public void setDescPeca(String descPeca) {
        this.descPeca = descPeca;
    }

    public int getQuantidadePeca() {
        return quantidadePeca;
    }

    public void setQuantidadePeca(int quantidadePeca) {
        this.quantidadePeca = quantidadePeca;
    }

    public Long getIdConserto() {
        return idConserto;
    }

    public void setIdConserto(Long idConserto) {
        this.idConserto = idConserto;
    }
}
