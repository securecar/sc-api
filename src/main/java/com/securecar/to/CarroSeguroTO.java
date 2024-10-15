package com.securecar.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CarroSeguroTO {
    private Long idCarroSeguro;
    @NotBlank
    @Size(min = 1, max = 1)
    private char statusSeguro;
    @NotNull
    private Long idSeguro;

    public CarroSeguroTO() {
    }

    public Long getIdCarroSeguro() {
        return idCarroSeguro;
    }

    public void setIdCarroSeguro(Long idCarroSeguro) {
        this.idCarroSeguro = idCarroSeguro;
    }

    public char getStatusSeguro() {
        return statusSeguro;
    }

    public void setStatusSeguro(char statusSeguro) {
        this.statusSeguro = statusSeguro;
    }

    public Long getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Long idSeguro) {
        this.idSeguro = idSeguro;
    }
}
