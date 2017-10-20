/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.leitor.view;

import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.TelaPadrao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jomar.cardoso
 */
public class TelaLeitor extends TelaPadrao implements ActionListener {
	
    private JTextField campoOrigem;
    private JTextField campoDestino;

    public TelaLeitor() {

        setTitle( "Interface Exemplo" );

        Container container = getContentPane();

        // Adicionando Botões e Ações
        JButton btn = new JButton( "Ação #1" );
        btn.setBounds( 425, 280, 120, 25 );
        container.add( btn );
        btn.setActionCommand( "B1" );

        btn.addActionListener( this );

        btn = new JButton( "Ação #2" );
        btn.setBounds( 550, 280, 120, 25 );
        container.add( btn );
        btn.setActionCommand( "B2" );

        btn.addActionListener( this );

        JTextField campoOrigem = criaCampoTexto( "Origem", 30, 400 );
        saltaLinha();
        campoDestino = criaCampoTexto( "Destino", 30, 400 );

        setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        JButton botaoOrigem = (JButton) evento.getSource();

        if( botaoOrigem.getActionCommand().equals( "B1" ) ) {

                String texto = campoOrigem.getText();
                texto = texto.toUpperCase();
                campoDestino.setText( texto );
        } else if( botaoOrigem.getActionCommand().equals( "B2" ) ) {
                JOptionPane.showMessageDialog( this, "Muito bem! Você conseguiu pressionar o botão!" );
        }	
    }

     //main será removido, está aqui apenas para testes
    public static void main(String[] args) {		
        new TelaLeitor();
    }
}