package com.securecar.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FeedbackTO {
    private Long idFeedback;
    @NotBlank
    private String comentarioFeedback;
    @Size(min = 1, max = 5)
    private int estrelasFeedback;

    private Long idUsuario;

    public FeedbackTO() {
    }

    public Long getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Long idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getComentarioFeedback() {
        return comentarioFeedback;
    }

    public void setComentarioFeedback(String comentarioFeedback) {
        this.comentarioFeedback = comentarioFeedback;
    }

    public int getEstrelasFeedback() {
        return estrelasFeedback;
    }

    public void setEstrelasFeedback(int estrelasFeedback) {
        this.estrelasFeedback = estrelasFeedback;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
