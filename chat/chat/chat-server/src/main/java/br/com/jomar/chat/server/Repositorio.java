package br.com.jomar.chat.server;

import br.com.jomar.chat.common.Inscricao;
import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.Topico;
import br.com.jomar.chat.common.Usuario;
import java.util.ArrayList;

/**
 * Classe Singleton com dados do servidor
 * 
 * @author jomar.cardoso
 */
public class Repositorio {

    private final ArrayList<Topico> topicos;
    private final ArrayList<Inscricao> inscricoes;
    private final ArrayList<Noticia> noticias;
    private final ArrayList<Usuario> leitores;
    private final ArrayList<Usuario> escritores;

    private static final Repositorio INSTANCE = new Repositorio();

    private Repositorio() {
        this.leitores = new ArrayList<>();
        this.escritores = new ArrayList<>();
        this.noticias = new ArrayList<>();
        this.inscricoes = new ArrayList<>();
        this.topicos = new ArrayList<>();
    }

    public static Repositorio getInstance() {
        return INSTANCE;
    }

    public ArrayList<Topico> getTopicos() {
        return topicos;
    }

    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public ArrayList<Usuario> getLeitores() {
        return leitores;
    }
    
    public ArrayList<Usuario> getEscritores() {
        return escritores;
    }
}
