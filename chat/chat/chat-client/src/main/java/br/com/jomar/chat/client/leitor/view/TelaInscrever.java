package br.com.jomar.chat.client.leitor.view;

import br.com.jomar.chat.client.Cliente;
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
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class TelaInscrever extends JInternalFrame {

    private JComboBox comboBox;
    private ClienteLeitor cliente;

    /**
     * Create the frame.
     */
    public TelaInscrever(ClienteLeitor cliente) {
        this.cliente = (ClienteLeitor) cliente;
        
        setClosable(true);
        setMaximizable(true);
        setTitle("Inscrição em Tópico");
        setBounds(100, 100, 344, 239);
        getContentPane().setLayout(null);

        comboBox = new JComboBox();
        comboBox.setBounds(55, 64, 211, 20);

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
        lblTpico.setBounds(55, 38, 46, 15);
        getContentPane().add(lblTpico);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    //IServiceLeitor service = new RmiClient<IServiceLeitor>().getService();
                    //final String ip = LeitorServer.getLocalHostLANAddress().getHostAddress();
                    //final int port = 12399;
//		            final LeitorServer server = new LeitorServer(port);
//		            Thread threadSocket = new Thread(server);
//		            threadSocket.start();

                    //System.out.println("Porta " + port + " aberta!");

                    //Leitor leitor = new Leitor(ip, port);
                    //ClienteLeitor leitorClient = new ClienteLeitor(service, leitor);

                    Topico topicoSelecionado = null;
                    for (Topico topico : cliente.buscaTopicos()) {
                        if (topico.getNome().equals(comboBox.getSelectedItem())) {
                            topicoSelecionado = topico;
                        }
                    }

                    cliente.inscrever((Leitor) cliente.getUsuario(), topicoSelecionado);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnSalvar.setBounds(117, 133, 89, 23);
        getContentPane().add(btnSalvar);

    }

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    TelaInscrever frame = new TelaInscrever();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
