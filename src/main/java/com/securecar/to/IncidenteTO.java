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

    public String getDesciIncidente() {
        return desciIncidente;
    }

    public void setDesciIncidente(String desciIncidente) {
        this.desciIncidente = desciIncidente;
    }

    public LocalDate getDataIncidente() {
        return dataIncidente;
    }

    public void setDataIncidente(LocalDate dataIncidente) {
        this.dataIncidente = dataIncidente;
    }

    public Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
