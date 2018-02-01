package br.com.cadastroaluno.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JMenuBar mbBarra;
	private JMenu jmArquivo, jmEditar, jmAjuda;
	private JMenuItem miCadastra, miSair, miLimpar, miInformacao;

	public Principal() {
		// Definições da tela
		setTitle("Cadastro de Aluno");
		setSize(740, 580);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// define a tela sem um Layout pronto
		getContentPane().setLayout(null);

		// Objetos da barra de menu
		mbBarra = new JMenuBar();

		jmArquivo = new JMenu("Arquivo");
		jmEditar = new JMenu("Editar");
		jmAjuda = new JMenu("Ajuda");

		miCadastra = new JMenuItem("Cadastra");
		miSair = new JMenuItem("Sair");
		miLimpar = new JMenuItem("Limpar");
		miInformacao = new JMenuItem("Informações");

		jmArquivo.add(miCadastra);
		jmArquivo.add(miSair);
		jmEditar.add(miLimpar);
		jmAjuda.add(miInformacao);

		mbBarra.add(jmArquivo);
		mbBarra.add(jmEditar);
		mbBarra.add(jmAjuda);

		setJMenuBar(mbBarra);

		// Evento dos itens do menu
		miCadastra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Cadastro().setVisible(true);

			}
		});
	}

	// getContentPane().add(menuBarra);

	public static void main(String[] args) {

		new Principal().setVisible(true);

	}

}
