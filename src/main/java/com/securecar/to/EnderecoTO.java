package com.securecar.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EnderecoTO {
    private Long idEndereco;

//    @Size(min = 9, max = 9, message = "Cep inválido!")

    @Size(min = 8, max = 8, message = "Cep inválido!")
    private String cep;
    @NotBlank
    private String nomeLogradouro;

    @NotNull
//    @Size(max = 4, message = "Número de logradouro deve ter no máximo 4 números")
    private int numeroLogradouro;


    @Size(max = 150, message = "Complemento muito grande!")
    private String complemento;



    @NotBlank
    private String bairro;
    @Size(min = 2, max = 2, message = "Unidade Federativa inválida!")
    @NotBlank
    private String uf;

    @NotBlank
    private String cidade;

    public EnderecoTO() {
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public int getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(int numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
