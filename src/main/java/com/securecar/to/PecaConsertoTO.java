package com.securecar.to;

import jakarta.validation.constraints.NotNull;

public class PecaConsertoTO {
    private Long idPecaConserto;
    @NotNull
    private Long idConserto;

    @NotNull
    private Long idPeca;

    public PecaConsertoTO() {
    }

    public Long getIdPecaConserto() {
        return idPecaConserto;
    }

    public void setIdPecaConserto(Long idPecaConserto) {
        this.idPecaConserto = idPecaConserto;
    }

    public Long getIdConserto() {
        return idConserto;
    }

    public void setIdConserto(Long idConserto) {
        this.idConserto = idConserto;
    }

    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }
}
