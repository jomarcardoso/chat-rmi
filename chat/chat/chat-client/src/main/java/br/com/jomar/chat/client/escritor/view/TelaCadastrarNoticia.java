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

public class TelaCadastrarNoticia extends JInternalFrame {

    private JTextField txtTitulo;
    private JComboBox comboBox;
    private JTextArea txtTexto;
    private ClienteEscritor cliente;

    /**
     * Create the frame.
     */
    public TelaCadastrarNoticia(ClienteEscritor cliente) {
        this.cliente = cliente;
        setMaximizable(true);
        setClosable(true);
        setTitle("Cadastrar Notícia");
        setBounds(100, 100, 638, 417);
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

        JLabel lblTtulo = new JLabel("Título:");
        lblTtulo.setBounds(28, 68, 46, 14);
        getContentPane().add(lblTtulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(28, 86, 560, 20);
        getContentPane().add(txtTitulo);
        txtTitulo.setColumns(10);

        JLabel lblTexto = new JLabel("Texto:");
        lblTexto.setBounds(28, 117, 46, 14);
        getContentPane().add(lblTexto);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 137, 560, 190);
        getContentPane().add(scrollPane);

        txtTexto = new JTextArea();
        scrollPane.setViewportView(txtTexto);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(272, 39, 110, 20);
        getContentPane().add(dateChooser);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //IServiceEscritor service;
                try {

                    //service = new RmiClient<IServiceEscritor>().getService();
                    //Escritor escritor = new Escritor();
                    //ClienteEscritor escritorClient = new ClienteEscritor(service, escritor);

                    Topico topicoSelecionado = null;
                    for (Topico topico : cliente.buscaTopicos()) {
                        if (topico.getNome().equals(comboBox.getSelectedItem())) {
                            topicoSelecionado = topico;
                        }
                    }
                    cliente.criarNoticia(topicoSelecionado, txtTexto.getText(), txtTitulo.getText());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnSalvar.setBounds(260, 353, 89, 23);
        getContentPane().add(btnSalvar);

    }
    
//        /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    TelaCadastrarNoticia frame = new TelaCadastrarNoticia();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

}
