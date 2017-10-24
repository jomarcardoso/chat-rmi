/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.leitor.view;

import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.client.TelaPadrao;
import br.com.jomar.chat.client.leitor.util.ClienteLeitor;
import br.com.jomar.chat.client.leitor.util.LeitorServer;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author jomar.cardoso
 */
public class TelaLeitor extends TelaPadrao implements ActionListener {

    private JTextField campoLogin;
    private JTextField campoSenha;

    public TelaLeitor(ClienteLeitor cliente) {

        super(cliente);

        setTitle("Login Leitor");

        Container container = getContentPane();

        JButton btn = new JButton("Login");
        btn.setBounds(167, 200, 88, 25);
        container.add(btn);
        btn.setActionCommand("B1");

        btn.addActionListener(this);

        btn = new JButton("Acessar Anônimo");
        btn.setBounds(265, 200, 150, 25);
        container.add(btn);
        btn.setActionCommand("B2");

        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    final String ip = LeitorServer.getLocalHostLANAddress().getHostAddress();

                    String nome = campoLogin.getText();
                    String senha = campoSenha.getText();
                    
                    cliente.login(nome);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(47, 201, 110, 23);
        getContentPane().add(btnNewButton);

        btn.addActionListener(this);

        campoLogin = criaCampoTexto("Login", 80, 200);
//        saltaLinha();
        campoSenha = criaCampoTexto("ip", 80, 200);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        JButton botaoOrigem = (JButton) evento.getSource();

        if (botaoOrigem.getActionCommand().equals("B1")) {

            try {
                String nome = campoLogin.getText();

                if (cliente.login(nome)) {
                    TelaPrincipalLeitor tela = new TelaPrincipalLeitor(false, (ClienteLeitor) this.cliente);
                    //tela.addWindowListener(exitListener);
                    tela.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent evt) {
                            //cliente.getServer().fecharSocket();
                        }
                    });
                    tela.setVisible(true);
                    dispose();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (botaoOrigem.getActionCommand().equals("B2")) {
            TelaPrincipalLeitor tela = new TelaPrincipalLeitor(true, (ClienteLeitor) this.cliente);
            tela.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent evt) {
                    //cliente.getServer().fecharSocket();
                }
            });
            tela.setVisible(true);
        }
    }

//    WindowListener exitListener = new WindowAdapter() {
//
//        @Override
//        public void windowClosing(WindowEvent e) {
//            int confirm = JOptionPane.showOptionDialog(
//                 null, "Are You Sure to Close Application?",
//                 "Exit Confirmation", JOptionPane.YES_NO_OPTION,
//                 JOptionPane.QUESTION_MESSAGE, null, null, null);
//            if (confirm == 0) {
//                cliente.getServer().fecharSocket();
//               System.exit(0);
//            }
//        }
//    };
}
