package br.com.jomar.chat.client.escritor.view;

import br.com.jomar.chat.client.escritor.util.ClienteEscritor;
import br.com.jomar.chat.client.leitor.util.ClienteLeitor;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalEscritor extends JFrame {

    private JPanel contentPane;
    private ClienteEscritor cliente;    

    /**
     * Create the frame.
     */
    public TelaPrincipalEscritor(ClienteEscritor cliente) {
        this.cliente = cliente;
        setTitle("Tela Principal Escritor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1099, 629);

        JDesktopPane desktopPane = new JDesktopPane();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnTpico = new JMenu("Cadastro");
        menuBar.add(mnTpico);

        JMenuItem mntmCadastrar = new JMenuItem("Cadastrar Tópico");
        mntmCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                TelaCadastrarTopico cadastrarTopico = new TelaCadastrarTopico(cliente);
                desktopPane.add(cadastrarTopico);
                cadastrarTopico.setVisible(true);

            }
        });
        mnTpico.add(mntmCadastrar);

        JMenuItem mntmCadastrarNotcia = new JMenuItem("Cadastrar Notícia");
        mntmCadastrarNotcia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                TelaCadastrarNoticia cadastrarNoticia = new TelaCadastrarNoticia(cliente);
                desktopPane.add(cadastrarNoticia);
                cadastrarNoticia.setVisible(true);

            }
        });
        mnTpico.add(mntmCadastrarNotcia);

        JMenu mnListagem = new JMenu("Listagem");
        menuBar.add(mnListagem);

        JMenuItem mntmListarTpicos = new JMenuItem("Listar Tópicos");
        mntmListarTpicos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaListarTopicos listarTopicos = new TelaListarTopicos(cliente);
                desktopPane.add(listarTopicos);
                listarTopicos.setVisible(true);
            }
        });
        mnListagem.add(mntmListarTpicos);

        JMenuItem mntmListarNotcias = new JMenuItem("Listar Notícias");
        mntmListarNotcias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaVisualizarTodasNoticias listarNoticias = new TelaVisualizarTodasNoticias(cliente);
                desktopPane.add(listarNoticias);
                listarNoticias.setVisible(true);
            }
        });
        mnListagem.add(mntmListarNotcias);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        contentPane.add(desktopPane, BorderLayout.CENTER);
    }

    //	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaPrincipalEscritor frame = new TelaPrincipalEscritor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
