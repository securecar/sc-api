package com.securecar.to;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.valueextraction.ExtractedValue;

public class TelefoneTO {
    private Long idTelefone;
    //o char SEMPRE virá em maiúsculo, devido ao método toUppercase da classe Charater, no Setter
    @Pattern(regexp = "^[AI]$", message = "O valor deve ser 'A' ou 'I'")
    private char status;
    //o char SEMPRE virá em maiúsculo, devido ao método toUppercase da classe Charater, no Setter
    @Pattern(regexp = "^[FM]$", message = "O valor deve ser 'F' ou 'M'")
    private char tipo;

    @Size(min = 2, max = 2, message = "O ddi deve conter 2 caracteres")
    private int ddi;

    @Size(min = 2, max = 2, message = "O ddd deve conter 2 caracteres")
    private int ddd;

    @Size(min = 8, max = 9, message = "O número de telefone deve contar entre 8 e 9 dígitos numéricos")
    private int telefone;

    public TelefoneTO() {
    }

    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public char getStatus() {
        return status;
    }


    public void setStatus(char status) {
        this.status = Character.toUpperCase(status);
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = Character.toUpperCase(tipo);
    }

    public int getDdi() {
        return ddi;
    }

    public void setDdi(int ddi) {
        this.ddi = ddi;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
