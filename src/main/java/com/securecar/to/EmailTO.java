package com.securecar.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailTO {
    private Long idEmail;
    @NotBlank
    private char status;
    @Email
    private String descricao;

    public EmailTO() {
    }

    public Long getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Long idEmail) {
        this.idEmail = idEmail;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
