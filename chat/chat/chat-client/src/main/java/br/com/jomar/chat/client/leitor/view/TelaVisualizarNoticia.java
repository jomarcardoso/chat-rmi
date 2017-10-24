package br.com.jomar.chat.client.leitor.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

import br.com.jomar.chat.client.leitor.util.ClienteLeitor;
import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.Topico;

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

		try {
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

					Topico topicoSelecionado = null;
					for (Topico topico : cliente.buscaTopicos()) {
						if (topico.getNome().equals(comboBox.getSelectedItem())) {
							topicoSelecionado = topico;
						}
					}
					Noticia noticia = cliente.buscaUltimaNoticia(topicoSelecionado);
					String noticiaParaTexto = noticia.getTopico().getNome() + "\n-\n" + noticia.getEscritor().getNome() + ": " + noticia.getTitulo() + "\n--\n" + noticia.getTexto() + "\n\n----------\n\n";
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
					ArrayList<Noticia> noticias = cliente.buscaNoticiasTopico(topicoSelecionado);
					//Noticia noticia =
					//noticias.add(noticia);
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
			noticiaFormatada += noticia.getData().toString() + " - " + noticia.getEscritor().getNome() + ": " + noticia.getTitulo() + "\n--\n" + noticia.getTexto() + "\n\n----------\n\n";
		}

		return noticiaFormatada;
	}
}
