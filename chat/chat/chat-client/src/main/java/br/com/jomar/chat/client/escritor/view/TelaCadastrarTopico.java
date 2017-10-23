package br.com.jomar.chat.client.escritor.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.jomar.chat.client.escritor.util.ClienteEscritor;
import br.com.jomar.chat.common.Escritor;
import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.RmiClient;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class TelaCadastrarTopico extends JInternalFrame {

    private JTextField nomeTopico;
    private ClienteEscritor cliente;

    /**
     * Create the frame.
     */
    public TelaCadastrarTopico(ClienteEscritor cliente) {
        this.cliente = cliente;
        setMaximizable(true);
        setClosable(true);
        setBounds(100, 100, 410, 258);
        getContentPane().setLayout(null);

        JLabel lblNomeDoTpico = new JLabel("Nome do tópico:");
        lblNomeDoTpico.setBounds(51, 59, 93, 14);
        getContentPane().add(lblNomeDoTpico);

        nomeTopico = new JTextField();
        nomeTopico.setBounds(154, 56, 164, 20);
        getContentPane().add(nomeTopico);
        nomeTopico.setColumns(10);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                IServiceEscritor service;
                //service = new RmiClient<IServiceEscritor>().getService();
                //Escritor escritor = new Escritor();
                //ClienteEscritor escritorClient = new ClienteEscritor(service, escritor);
                
                cliente.criarTopico(nomeTopico.getText());

            }
        });
        btnSalvar.setBounds(147, 137, 89, 23);
        getContentPane().add(btnSalvar);

    }
    
//        /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    TelaCadastrarTopico frame = new TelaCadastrarTopico();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
