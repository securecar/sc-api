package com.securecar.to;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ConsertoTO {
    private Long idConserto;
    @FutureOrPresent
    private LocalDate dataConserto;
    @NotBlank
    private String descricaoConserto;
    @PositiveOrZero
    private double valorConserto;
    @NotNull
    private Long idUsuario;

    @Nullable
    private Double valorTotalConserto;

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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Nullable
    public Double getValorTotalConserto() {
        return valorTotalConserto;
    }

    public void setValorTotalConserto(@Nullable Double valorTotalConserto) {
        this.valorTotalConserto = valorTotalConserto;
    }
}
