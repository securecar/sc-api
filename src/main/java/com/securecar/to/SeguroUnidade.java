package com.securecar.to;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SeguroUnidade {
    private Long idUnidade;
    @NotEmpty
    private String nomeUnidade;
    @NotNull
    private Long idEndereco;

    @NotNull
    private Long idSeguro;

    @NotNull
    private Long idContato;
}
