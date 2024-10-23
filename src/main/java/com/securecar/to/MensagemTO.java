package com.securecar.to;

import jakarta.validation.constraints.NotNull;

public class MensagemTO {
    private Long idConversa;
    @NotNull
    private Long idMensagem;
    @NotNull
    private int tipoMensagem;
    @NotNull
    private String textoMensagem;

    public MensagemTO() {
    }

    public Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public Long getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Long idMensagem) {
        this.idMensagem = idMensagem;
    }

    public int getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(int tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    public String getTextoMensagem() {
        return textoMensagem;
    }

    public void setTextoMensagem(String textoMensagem) {
        this.textoMensagem = textoMensagem;
    }
}
