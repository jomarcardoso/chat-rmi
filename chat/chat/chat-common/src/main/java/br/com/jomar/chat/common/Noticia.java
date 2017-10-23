package br.com.jomar.chat.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jomar
 */
public class Noticia implements Serializable, IMensagem {

    private String texto;
    private String titulo;
    private Topico topico;
    private Date data;

    public Noticia(String texto, String titulo, Topico topico, Date data) {
        this.texto = texto;
        this.titulo = titulo;
        this.topico = topico;
        this.data = data;
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
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
