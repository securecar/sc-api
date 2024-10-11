package com.securecar.to;

import java.time.LocalDate;

public class ConsertoTO {
    private Long idConserto;
    private LocalDate dataConserto;
    private String descricaoConserto;
    private double valorConserto;
    private Long idIncidente;

    public ConsertoTO() {
    }

    public Long getIdConserto() {
        return idConserto;
    }

    public void setIdConserto(Long idConserto) {
        this.idConserto = idConserto;
    }

    public LocalDate getDataConserto() {
        return dataConserto;
    }

    public void setDataConserto(LocalDate dataConserto) {
        this.dataConserto = dataConserto;
    }

    public String getDescricaoConserto() {
        return descricaoConserto;
    }

    public void setDescricaoConserto(String descricaoConserto) {
        this.descricaoConserto = descricaoConserto;
    }

    public double getValorConserto() {
        return valorConserto;
    }

    public void setValorConserto(double valorConserto) {
        this.valorConserto = valorConserto;
    }

    public Long getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Long idIncidente) {
        this.idIncidente = idIncidente;
    }
}
