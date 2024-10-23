package com.securecar.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class IncidenteTO {
    private Long idIncidente;
    @NotBlank
    private String desciIncidente;
    @NotBlank
    @PastOrPresent
    private LocalDate dataIncidente;
    @NotNull
    private Long idConversa;
    @NotNull
    private Long idUsuario;

    public IncidenteTO() {
    }

    public Long getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Long idIncidente) {
        this.idIncidente = idIncidente;
    }

    public @NotBlank String getDesciIncidente() {
        return desciIncidente;
    }

    public void setDesciIncidente(@NotBlank String desciIncidente) {
        this.desciIncidente = desciIncidente;
    }

    public @NotBlank @PastOrPresent LocalDate getDataIncidente() {
        return dataIncidente;
    }

    public void setDataIncidente(@NotBlank @PastOrPresent LocalDate dataIncidente) {
        this.dataIncidente = dataIncidente;
    }

    public @NotNull Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(@NotNull Long idConversa) {
        this.idConversa = idConversa;
    }

    public @NotNull Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(@NotNull Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
