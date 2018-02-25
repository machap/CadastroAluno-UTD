package br.com.cadastroaluno.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends JFrame {

	private JMenuBar mbBarra;
	private JMenu jmArquivo, jmFuncao, jmAjuda;
	protected JMenuItem miCadastra;
	protected JMenuItem miConsultar;
	protected JMenuItem miSair;
	protected JMenuItem miLimpar;
	protected JMenuItem miEditar;
	protected JMenuItem miInformacao;
	protected JButton btnAdiciona, btnConsulta;

	private ImageIcon adc, find;

	public Principal() {
		// Definições da tela
		setTitle("Menu");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// define a tela sem um Layout pronto
		getContentPane().setLayout(null);

		// Objetos da barra de menu
		mbBarra = new JMenuBar();

		jmArquivo = new JMenu("Arquivo");
		jmFuncao = new JMenu("Função");
		jmAjuda = new JMenu("Ajuda");

		miCadastra = new JMenuItem("Cadastra");
		miConsultar = new JMenuItem("Consultar");
		miSair = new JMenuItem("Sair");
		miLimpar = new JMenuItem("Limpar");
		miEditar = new JMenuItem("Editar");
		miInformacao = new JMenuItem("Informações");

		adc = new ImageIcon("/home/paulo/eclipse-workspace/gitHub/CadastroAluno-UTD/icon/add.png");
		btnAdiciona = new JButton(adc);
		getContentPane().add(btnAdiciona);
		btnAdiciona.setBounds(30, 50, 256, 256);

		find = new ImageIcon("/home/paulo/eclipse-workspace/gitHub/CadastroAluno-UTD/icon/busca.png");
		btnConsulta = new JButton(find);
		getContentPane().add(btnConsulta);
		btnConsulta.setBounds(350, 50, 256, 256);

		jmArquivo.add(miCadastra);
		jmArquivo.add(miConsultar);
		jmArquivo.add(miSair);
		jmFuncao.add(miLimpar);
		jmFuncao.add(miEditar);
		jmAjuda.add(miInformacao);

		mbBarra.add(jmArquivo);
		mbBarra.add(jmFuncao);
		mbBarra.add(jmAjuda);

		setJMenuBar(mbBarra);

		btnAdiciona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Cadastro().setVisible(true);

			}
		});

		// Evento dos itens do menu
		miCadastra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				btnAdiciona.doClick();

			}
		});

		btnConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Consulta().setVisible(true);

			}
		});

		miConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				btnConsulta.doClick();
			}
		});

		miSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});

		miLimpar.setEnabled(false);
		miEditar.setEnabled(false);

		miInformacao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Desenvolvido por: \nPaulo Victor\nCurso Java com banco de Dados \nUTD© 2018", "Informações",
						1);

			}
		});
	}

	public static void main(String[] args) {

		new Principal().setVisible(true);

	}

}
