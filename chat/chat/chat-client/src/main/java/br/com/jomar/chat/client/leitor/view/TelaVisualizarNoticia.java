package br.com.jomar.chat.client.leitor.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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

public class TelaVisualizarNoticia extends JInternalFrame {

    private JComboBox comboBox;
    private JTextArea txtTexto;
    private ClienteLeitor cliente;

    /**
     * Create the frame.
     */
    public TelaVisualizarNoticia(String noticia, ClienteLeitor cliente) {
        super();
        this.cliente = cliente;
        setMaximizable(true);
        setClosable(true);
        setTitle("Cadastrar Notícia");
        setBounds(100, 100, 798, 511);
        getContentPane().setLayout(null);

        comboBox = new JComboBox();
        comboBox.setBounds(28, 39, 211, 20);

        //IServiceEscritor service;
        try {
            //service = new RmiClient<IServiceEscritor>().getService();
            //Escritor escritor = new Escritor();
            //ClienteEscritor escritorClient = new ClienteEscritor(service, escritor);

            for (Topico topico : cliente.buscaTopicos()) {
                comboBox.addItem(topico.getNome());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        getContentPane().add(comboBox);

        JLabel lblTpico = new JLabel("Tópico:");
        lblTpico.setBounds(28, 19, 46, 15);
        getContentPane().add(lblTpico);

        JLabel lblTexto = new JLabel("Notícia:");
        lblTexto.setBounds(28, 117, 46, 14);
        getContentPane().add(lblTexto);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 136, 728, 334);
        getContentPane().add(scrollPane);

        txtTexto = new JTextArea();
        scrollPane.setViewportView(txtTexto);

        if (noticia != null) {
            noticia = noticia.replace("-", "\n--\n");
            txtTexto.setText("Tópico: " + noticia);
        }

        JButton btnSalvar = new JButton("Buscar Última Notícia");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    IServiceLeitor service = new RmiClient<IServiceLeitor>().getService();
                    final String ip = LeitorServer.getLocalHostLANAddress().getHostAddress();
                    final int port = 12399;
//		            final LeitorServer server = new LeitorServer(port);
//		            Thread threadSocket = new Thread(server);
//		            threadSocket.start();

                    System.out.println("Porta " + port + " aberta!");

                    Leitor leitor = new Leitor(ip, port);
                    ClienteLeitor leitorClient = new ClienteLeitor(service, leitor);

                    Topico topicoSelecionado = null;
                    for (Topico topico : leitorClient.buscaTopicos()) {
                        if (topico.getNome().equals(comboBox.getSelectedItem())) {
                            topicoSelecionado = topico;
                        }
                    }

//		            leitorClient.buscaNoticiasIntervalo(topico)
                    Noticia noticia = leitorClient.buscaUltimaNoticia(topicoSelecionado);
                    String noticiaParaTexto = noticia.getTopico().getNome() + "\n-\n" + noticia.getTitulo() + "\n--\n" + noticia.getTexto() + "\n\n----------\n\n";
                    txtTexto.setText(noticiaParaTexto);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnSalvar.setBounds(438, 36, 157, 23);
        getContentPane().add(btnSalvar);

        JButton btnNewButton = new JButton("Buscar por tópico");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {

                    Topico topicoSelecionado = null;
                    for (Topico topico : cliente.buscaTopicos()) {
                        if (topico.getNome().equals(comboBox.getSelectedItem())) {
                            topicoSelecionado = topico;
                        }
                    }
                    ArrayList<Noticia> noticias = new ArrayList<>();
                    Noticia noticia = cliente.buscaUltimaNoticia(topicoSelecionado);
                    noticias.add(noticia);
                    String noticiaParaTexto = buscaNoticiaFormatada(noticias);
                    txtTexto.setText(noticiaParaTexto);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(260, 36, 168, 23);
        getContentPane().add(btnNewButton);

        JDateChooser dateInicial = new JDateChooser();
        dateInicial.setBounds(28, 70, 143, 20);
        getContentPane().add(dateInicial);

        JDateChooser dateFinal = new JDateChooser();
        dateFinal.setBounds(181, 70, 143, 20);
        getContentPane().add(dateFinal);

        JButton btnNewButton_1 = new JButton("Busca por intervalor de data");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {

                    //IServiceLeitor service = new RmiClient<IServiceLeitor>().getService();
                    final String ip = LeitorServer.getLocalHostLANAddress().getHostAddress();
                    final int port = 12399;

                    //Leitor leitor = new Leitor(ip, port);
                    //ClienteLeitor leitorClient = new ClienteLeitor(service, leitor);

                    Topico topicoSelecionado = null;
                    for (Topico topico : cliente.buscaTopicos()) {
                        if (topico.getNome().equals(comboBox.getSelectedItem())) {
                            topicoSelecionado = topico;
                        }
                    }

                    ArrayList<Noticia> noticias = cliente.buscaNoticiasIntervaloData(topicoSelecionado, dateInicial.getDate(), dateFinal.getDate());
                    String noticiaParaTexto = buscaNoticiaFormatada(noticias);
                    txtTexto.setText(noticiaParaTexto);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnNewButton_1.setBounds(350, 70, 168, 23);
        getContentPane().add(btnNewButton_1);

    }

    public String buscaNoticiaFormatada(ArrayList<Noticia> noticias) {

        String noticiaFormatada = "";
        for (Noticia noticia : noticias) {
            noticiaFormatada += noticia.getData().toString() + " - " + noticia.getTitulo() + "\n--\n" + noticia.getTexto() + "\n\n----------\n\n";
        }

        return noticiaFormatada;
    }

    //	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaVisualizarNoticia frame = new TelaVisualizarNoticia( null );
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
