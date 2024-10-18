package com.securecar.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmailTO {
    private Long idEmail;
    @NotBlank(message = "")
    @Pattern(regexp = "^[AI]$", message = "O valor deve ser 'A' ou 'I'")
    private char status;
    @Email(message = "Insira um email válido!")
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
