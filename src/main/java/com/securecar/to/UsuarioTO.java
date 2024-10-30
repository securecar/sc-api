package com.securecar.to;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class UsuarioTO {
    private Long idUsuario;

    @NotEmpty
    private String nomeUsuario;


    private LocalDate dataCriacaoConta;

    @CPF
    private String cpf;

    @NotEmpty
    private String senha;

    @NotEmpty
    private String genero;
    @Size(min = 9, max = 9, message = "RG inválido!")
    @NotNull
    private String rg;

    @NotNull
    private Long idContato;

    @NotNull
    private Long idEndereco;

    public UsuarioTO() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDate getDataCriacaoConta() {
        return dataCriacaoConta;
    }

    public void setDataCriacaoConta(LocalDate dataCriacaoConta) {
        this.dataCriacaoConta = dataCriacaoConta;
    }



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
