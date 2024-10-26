package com.securecar.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EnderecoTO {
    private Long idEndereco;

    @Size(min = 9, max = 9, message = "Cep inválido!")
    private int cep;
    @NotBlank
    private String nomeLogradouro;

    @NotNull
    @Size(max = 4, message = "Número de logradouro deve ter no máximo 4 números")
    private int numeroLogradouro;

    @NotBlank
    @Size(max = 150, message = "Complemento muito grande!")
    private String complemento;


    @NotBlank
    private String bairro;
    @Size(min = 2, max = 2, message = "Unidade Federativa inválida!")
    @NotBlank
    private String uf;

    @NotBlank
    private String cidade;
}
