/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.escritor.view;

import br.com.jomar.chat.client.TelaPadrao;
import br.com.jomar.chat.client.escritor.util.ClienteEscritor;
import br.com.jomar.chat.common.Escritor;
import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.RmiClient;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author jomar.cardoso
 */
public class TelaEscritor extends TelaPadrao implements ActionListener {

    private JTextField campoLogin;
    private JTextField campoSenha;

    public TelaEscritor(ClienteEscritor cliente) {
        super(cliente);

        setTitle("Login Escritor");

        Container container = getContentPane();

        JButton btn = new JButton("Login");
        btn.setBounds(120, 200, 120, 25);
        container.add(btn);
        btn.setActionCommand("B1");

        btn.addActionListener(this);

        btn = new JButton("Cadastrar");
        btn.setBounds(250, 200, 120, 25);
        container.add(btn);
        btn.setActionCommand("B2");

        btn.addActionListener(this);

        campoLogin = criaCampoTexto("Login", 80, 200);
        saltaLinha();
        campoSenha = criaCampoSenha("Senha", 80, 200);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        JButton botaoOrigem = (JButton) evento.getSource();

        if (botaoOrigem.getActionCommand().equals("B1")) {

            try {
                IServiceEscritor service;
                service = new RmiClient<IServiceEscritor>().getService();

                String login = campoLogin.getText();
                String senha = campoSenha.getText();
                //Escritor escritor = new Escritor();
                //ClienteEscritor escritorClient = new ClienteEscritor(service, escritor);

                if (cliente.login(login)) {
                    TelaPrincipalEscritor tela = new TelaPrincipalEscritor((ClienteEscritor) cliente);
                    tela.setVisible(true);
                    dispose();
                }

            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }

        } else if (botaoOrigem.getActionCommand().equals("B2")) {

            try {
                IServiceEscritor service;
                service = new RmiClient<IServiceEscritor>().getService();

                String login = campoLogin.getText();
                //String senha = campoSenha.getText();
                //Escritor escritor = new Escritor();
                //ClienteEscritor escritorClient = new ClienteEscritor(service, escritor);

                cliente.login(login);

            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }

        }
    }

}
