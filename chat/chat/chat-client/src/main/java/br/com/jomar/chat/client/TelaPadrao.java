/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jomar.cardoso
 */
public abstract class TelaPadrao extends JFrame implements WindowListener {

	private int nrLinha = 70;
	private JLabel lbl;
	
	public TelaPadrao() {

		super.setBounds( 100, 100, 700, 350 );
		
		setLayout( null );
		lbl = new JLabel( "CHAT RMI" ); 
		// 2) Posicionar o elemento na tela
		lbl.setBounds( 0, 0, 700, 30 );
		// 3) Adicionar ao container
		getContentPane().add( lbl );		

		Color cor1 = new Color( 235, 99, 71 );

		lbl.setForeground( Color.BLUE );
		lbl.setOpaque( true );
		lbl.setHorizontalAlignment( JLabel.CENTER );
		lbl.setBackground( cor1 );
		
		Font tpLetra = new Font( "Bangla MN", Font.PLAIN, 16 );
		lbl.setFont( tpLetra );

		addWindowListener( this );
		setDefaultCloseOperation( DO_NOTHING_ON_CLOSE );
	}
	
	@Override
	public void setBounds( int x, int y, int width, int height ) {
		super.setBounds(x, y, width, height);
		
		if( lbl != null ) {
			lbl.setBounds( 0, 0, width, 30 );
		}
	}
	
	public JTextField criaCampoTexto( String txtLabel, int x, int largura ) {
		
		JLabel lbl1 = new JLabel( txtLabel );
		lbl1.setBounds( x, nrLinha, 150, 23 );
		getContentPane().add( lbl1 );
		
		JTextField tf = new JTextField();
		tf.setBounds( x + 90, nrLinha, largura, 23 );
		getContentPane().add( tf );
		
		return tf;
	}
	
	public JTextField criaCampoNumerico( String txtLabel, int x, int largura ) {
		
		JLabel lbl1 = new JLabel( txtLabel );
		lbl1.setBounds( x, nrLinha, 150, 23 );
		getContentPane().add( lbl1 );
		
		JTextField tf = new JTextField();
		tf.setBounds( x + 90, nrLinha, largura, 23 );
		getContentPane().add( tf );
		
		tf.addKeyListener( new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				char ch = e.getKeyChar();
				
				if( !Character.isDigit( ch ) ) {
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				if( e.getKeyCode() == KeyEvent.VK_F1 ) {
					System.out.println( "Soltei o F1");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		return tf;
	}
	
	public void saltaLinha() {
		nrLinha += 27;
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		
		if( JOptionPane.showConfirmDialog( this, 
				"Tem certeza que quer sair do programa?",
				"Confirme",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE ) == JOptionPane.YES_OPTION ) {
			dispose();
		}
	}
	
	private class MeuMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}
		
		@Override
		public void mouseExited(MouseEvent e) {}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}