package com.securecar.to;

import jakarta.validation.constraints.NotNull;

public class MensagemTO {
    @NotNull
    private Long idConversa;
    @NotNull
    private Long idMensagem;
    @NotNull
    private int tipoMensagem;
    @NotNull
    private String textoMensagem;

    public MensagemTO() {
    }

    public @NotNull Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(@NotNull Long idConversa) {
        this.idConversa = idConversa;
    }

    public @NotNull Long getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(@NotNull Long idMensagem) {
        this.idMensagem = idMensagem;
    }

    @NotNull
    public int getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(@NotNull int tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    public @NotNull String getTextoMensagem() {
        return textoMensagem;
    }

    public void setTextoMensagem(@NotNull String textoMensagem) {
        this.textoMensagem = textoMensagem;
    }
}
