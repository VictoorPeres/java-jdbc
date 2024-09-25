package br.com.avancard.model;

import java.util.ArrayList;
import java.util.List;

public class Telefonejdbc {
    private long cd_telefone;
    private String numero;
    private long cd_usuario;

    public long getCd_telefone() {
        return cd_telefone;
    }

    public void setCd_telefone(long cd_telefone) {
        this.cd_telefone = cd_telefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public long getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(long cd_usuario) {
        this.cd_usuario = cd_usuario;
    }
}
