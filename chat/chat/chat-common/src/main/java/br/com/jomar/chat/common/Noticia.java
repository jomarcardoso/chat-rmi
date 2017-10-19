package br.com.jomar.chat.common;

import java.io.Serializable;

/**
 * @author Jomar
 */
public class Noticia implements Serializable {

    private String texto;
    private String titulo;
    private Topico topico;

    public Noticia(String texto, String titulo, Topico topico) {
        this.texto = texto;
        this.titulo = titulo;
        this.topico = topico;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

}
