package com.securecar.to;

public class CarroSeguroTO {
    private Long idCarroSeguro;
    private char statusSeguro;
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
