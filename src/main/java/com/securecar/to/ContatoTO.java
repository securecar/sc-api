package com.securecar.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class ContatoTO {
    private Long idContato;

    @Email
    private String email;

    @NotNull
    private Long telefone;

    public ContatoTO() {
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
}
