package com.securecar.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ConversaTO {
    private Long idConversa;
    @PastOrPresent
    private LocalDate dataConversa;
    @NotNull
    private Long idIncidente;

    public ConversaTO() {
    }

    public Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public LocalDate getDataConversa() {
        return dataConversa;
    }

    public void setDataConversa(LocalDate dataConversa) {
        this.dataConversa = dataConversa;
    }

    public Long getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Long idIncidente) {
        this.idIncidente = idIncidente;
    }
}
