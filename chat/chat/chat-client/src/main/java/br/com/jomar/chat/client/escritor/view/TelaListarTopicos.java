package br.com.jomar.chat.client.escritor.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.jomar.chat.client.escritor.util.ClienteEscritor;
import br.com.jomar.chat.common.Escritor;
import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;

public class TelaListarTopicos extends JInternalFrame {

    private JTextArea txtTexto;
    ClienteEscritor cliente;

    /**
     * Create the frame.
     */
    public TelaListarTopicos(ClienteEscritor cliente) {
        this.cliente = cliente;
        setMaximizable(true);
        setClosable(true);
        setTitle("Cadastrar Notícia");
        setBounds(100, 100, 344, 319);
        getContentPane().setLayout(null);

        JLabel lblTpico = new JLabel("Tópicos:");
        lblTpico.setBounds(21, 29, 78, 15);
        getContentPane().add(lblTpico);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 55, 281, 190);
        getContentPane().add(scrollPane);

        txtTexto = new JTextArea();
        txtTexto.setEditable(false);
        scrollPane.setViewportView(txtTexto);

        IServiceEscritor service;
        try {
            //service = new RmiClient<IServiceEscritor>().getService();
            //Escritor escritor = new Escritor();
            //ClienteEscritor escritorClient = new ClienteEscritor(service, escritor);

            String topicosTexto = "";
            for (Topico topico : cliente.buscaTopicos()) {
                topicosTexto += topico.getNome() + "\n";
            }
            txtTexto.setText(topicosTexto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    TelaListarTopicos frame = new TelaListarTopicos();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
