package br.com.jomar.chat.client.escritor.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.jomar.chat.client.escritor.util.ClienteEscritor;
import br.com.jomar.chat.client.leitor.util.ClienteLeitor;
import br.com.jomar.chat.client.leitor.util.LeitorServer;
import br.com.jomar.chat.common.Escritor;
import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

public class TelaVisualizarTodasNoticias extends JInternalFrame {

    private JTextArea txtTexto;
    ClienteEscritor cliente;

    /**
     * Create the frame.
     */
    public TelaVisualizarTodasNoticias(ClienteEscritor cliente) {
        this.cliente = cliente;
        setMaximizable(true);
        setClosable(true);
        setTitle("Cadastrar Notícia");
        setBounds(100, 100, 798, 511);
        getContentPane().setLayout(null);

        JLabel lblTexto = new JLabel("Notícias:");
        lblTexto.setBounds(28, 11, 113, 14);
        getContentPane().add(lblTexto);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 30, 728, 440);
        getContentPane().add(scrollPane);

        txtTexto = new JTextArea();
        txtTexto.setEditable(false);
        scrollPane.setViewportView(txtTexto);

        IServiceEscritor service;
        try {
            //service = new RmiClient<IServiceEscritor>().getService();
            //Escritor escritor = new Escritor();
            //ClienteEscritor escritorClient = new ClienteEscritor(service, escritor);
            ArrayList<Noticia> noticias = cliente.buscaTodasNoticias();

            if (noticias != null) {
                String noticiaParaTexto = buscaNoticiaFormatada(noticias);
                txtTexto.setText(noticiaParaTexto);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Não possui notícias cadastradas");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String buscaNoticiaFormatada(ArrayList<Noticia> noticias) {

        String noticiaFormatada = "";
        for (Noticia noticia : noticias) {
            noticiaFormatada += noticia.getData().toString() + "\nTópico: " + noticia.getTopico().getNome() + " - " + noticia.getTitulo() + "\n--\n" + noticia.getTexto() + "\n\n----------\n\n";
        }

        return noticiaFormatada;
    }
    
    
//        /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    TelaVisualizarTodasNoticias frame = new TelaVisualizarTodasNoticias();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
