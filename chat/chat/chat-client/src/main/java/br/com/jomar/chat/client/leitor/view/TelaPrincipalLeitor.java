package br.com.jomar.chat.client.leitor.view;

import br.com.jomar.chat.client.Cliente;
import br.com.jomar.chat.client.leitor.util.ClienteLeitor;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.jomar.chat.client.leitor.util.LeitorServer;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalLeitor extends JFrame {

    private JPanel contentPane;
    private JDesktopPane desktopPane;
    private ClienteLeitor cliente;

    /**
     * Create the frame.
     */
    public TelaPrincipalLeitor(boolean ehAnonimo, ClienteLeitor cliente) {
        super();
        this.cliente = cliente;

//        try {
//            final int port = 12399;
//            final LeitorServer server = new LeitorServer(port, this);
//            Thread threadSocket = new Thread(server);
//            threadSocket.start();
//            System.out.println("Porta " + port + " aberta!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        setTitle("Tela Principal Leitor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1099, 629);

        desktopPane = new JDesktopPane();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnTpico = new JMenu("Leitor");
        menuBar.add(mnTpico);

        if (!ehAnonimo) {
            JMenuItem mntmCadastrar = new JMenuItem("Inscrição em tópico");
            mntmCadastrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    TelaInscrever inscrever = new TelaInscrever(cliente);
                    desktopPane.add(inscrever);
                    inscrever.setVisible(true);

                }
            });
            mnTpico.add(mntmCadastrar);
        }

        JMenuItem mntmCadastrarNotcia = new JMenuItem("Visualizar Notícia");
        mntmCadastrarNotcia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                TelaVisualizarNoticia visualizarNoticia = new TelaVisualizarNoticia(null, cliente);
                desktopPane.add(visualizarNoticia);
                visualizarNoticia.setVisible(true);

            }
        });
        mnTpico.add(mntmCadastrarNotcia);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        contentPane.add(desktopPane, BorderLayout.CENTER);
    }

    public void mostraNovaNoticia(String noticia) {

        TelaVisualizarNoticia visualizarNoticia = new TelaVisualizarNoticia(noticia, cliente);
        desktopPane.add(visualizarNoticia);
        visualizarNoticia.setVisible(true);

    }
    
        /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    TelaPrincipalLeitor frame = new TelaPrincipalLeitor(false);
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

}
