package br.com.jomar.chat.common;

import java.io.Serializable;

/**
 * @author Jomar
 */
public class Inscricao implements Serializable {

    private Leitor leitor;
    private Topico topico;

    public Inscricao() {
    }

    public Inscricao(Leitor leitor, Topico topico) {
        this.leitor = leitor;
        this.topico = topico;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

}
