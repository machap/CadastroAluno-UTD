package br.com.cadastroaluno.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Cadastro extends JFrame{
	
	private JLabel lbApresentação, lbCodigo, lbNome, lbEmail, lbCidade, lbBairro, lbCurso, lbFoto, lbLogica;
	private JTextField tfCodigo, tfNome, tfEmail, tfBairro;
	private JButton btnConcluir, btnConsultar, btnLimpar;
	private JComboBox cbCidade, cbCurso;
	private JRadioButton rbSim, rbNao;
	private ButtonGroup bgLogica;

	public void limpar() {

		tfCodigo.setText("");
		tfNome.setText("");
		tfEmail.setText("");
		cbCidade.setSelectedIndex(0);
		tfBairro.setText("");
		cbCurso.setSelectedIndex(0);
		bgLogica.clearSelection();
	}

	public void inicializarComponentes() {

		// Define um titulo para o Frame
		setTitle("Cadastro de Alunos");
		// Define o tamanho do frame
		setSize(640, 480);
		//
		getContentPane().setBackground(new Color(135, 206, 250));
		// Define a Localização
		setLocationRelativeTo(null);
		// Encerra a aplicação quando é fechada
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// Instancia dos objetos, Label TextFild e Button
		lbApresentação = new JLabel("Insira as informações abaixo para se inscrever");
		lbCodigo = new JLabel("Código");
		lbNome = new JLabel("Nome");
		lbEmail = new JLabel("Email");
		lbCidade = new JLabel("Cidade");
		lbBairro = new JLabel("Bairro");
		lbCurso = new JLabel("Curso");
		lbFoto = new JLabel("Foto");
		lbLogica = new JLabel("Você sabe logica de programação ?");

		tfCodigo = new JTextField();
		tfNome = new JTextField();
		tfEmail = new JTextField();
		tfBairro = new JTextField();

		btnConcluir = new JButton("Concluir");
		btnConsultar = new JButton("Consultar");
		btnLimpar = new JButton("Limpar");

		rbSim = new JRadioButton("Sim");
		rbNao = new JRadioButton("Não");

		bgLogica = new ButtonGroup();

		String[] cidades = { "Selecione", "Caucaia", "Fortaleza", "Maracanau" };
		cbCidade = new JComboBox<String>(cidades);

		String[] cursos = { "Selecione", "Java", "Python", "PHP", "Android" };
		cbCurso = new JComboBox<String>(cursos);

		getContentPane().setLayout(null);

		// Coordenadas das posições dos componentes, Label TextFild e Button
		lbApresentação.setBounds(100, 110, 400, 20);
		lbCodigo.setBounds(20, 145, 50, 20);
		lbNome.setBounds(20, 175, 50, 20);
		lbEmail.setBounds(20, 210, 50, 20);
		lbCidade.setBounds(20, 245, 50, 20);
		lbBairro.setBounds(20, 280, 50, 20);
		lbCurso.setBounds(20, 315, 50, 20);
		lbFoto.setBounds(400, 350, 50, 20);
		lbLogica.setBounds(20, 350, 250, 20);

		tfCodigo.setBounds(100, 145, 50, 25);
		tfNome.setBounds(100, 175, 200, 25);
		tfEmail.setBounds(100, 210, 200, 25);

		tfBairro.setBounds(100, 280, 200, 25);

		btnConcluir.setBounds(90, 410, 100, 30);
		btnConsultar.setBounds(220, 410, 110, 30);
		btnLimpar.setBounds(360, 410, 100, 30);

		cbCidade.setBounds(100, 245, 200, 20);
		cbCurso.setBounds(100, 315, 200, 20);

		rbSim.setBounds(40, 375, 60, 20);
		rbNao.setBounds(120, 375, 60, 20);

		// rbSim.setBounds(x, y, width, height);

		// Adiciona os componenetes na Frame
		getContentPane().add(lbApresentação);
		getContentPane().add(lbCodigo);
		getContentPane().add(lbNome);
		getContentPane().add(lbCidade);
		getContentPane().add(lbBairro);
		getContentPane().add(lbCurso);
		getContentPane().add(lbFoto);
		getContentPane().add(lbEmail);
		getContentPane().add(lbLogica);

		getContentPane().add(tfCodigo);
		getContentPane().add(tfNome);
		getContentPane().add(tfEmail);
		getContentPane().add(tfBairro);

		getContentPane().add(btnConcluir);
		getContentPane().add(btnConsultar);
		getContentPane().add(btnLimpar);

		getContentPane().add(cbCidade);
		getContentPane().add(cbCurso);

		getContentPane().add(rbSim);
		getContentPane().add(rbNao);

		bgLogica.add(rbSim);
		bgLogica.add(rbNao);

	}

	public void definirEventos() {

		// Evento para o botão limpar
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				limpar();
				;
			}
		});

		btnConcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tfCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O Código não pode está vazio!");
					// Coloca o cursor na caixa de texto correspondente
					tfCodigo.requestFocus();
				} else if (tfNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O Nome não pode está vazio!");

					tfNome.requestFocus();
				} else if (cbCidade.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "A Cidade não pode está vazio!");

					cbCidade.requestFocus();
				} else if (lbBairro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O Bairro não pode está vazio!");

					lbBairro.requestFocus();
				} else if (cbCurso.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "O Curso não pode está vazio!");

					cbCurso.requestFocus();
				} else {

					// Tratamento de erros
					try {

						File Arquivo = new File(tfCodigo.getText() + ".txt");

						if (Arquivo.exists()) {
							JOptionPane.showMessageDialog(null, "Arquivo já Existe", "Alerta",
									JOptionPane.ERROR_MESSAGE);
						} else {
							// Instancia o objeto para gravação do arquivo
							PrintWriter out = new PrintWriter(tfCodigo.getText() + ".txt");
							// captura os dados
							out.println(tfCodigo.getText());
							out.println(tfNome.getText());
							out.println(tfEmail.getText());
							out.println(cbCidade.getSelectedItem());
							out.println(tfBairro.getText());
							out.println(cbCurso.getSelectedItem());
							// out.println(bgLogica.getSelection());

							if (rbSim.isSelected()) {
								out.println(rbNao.getText());
							} else {
								out.println(rbSim.getText());
							}

							out.close();

							JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso !");

							limpar();
						}

					} catch (IOException erro) {
						JOptionPane.showMessageDialog(null, "Erro ao Gravar " + erro);
					}

				}
			}
		});

		// Evento do botão Consultar
		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Solicita que o usuario informe o codigo do arquivo a
					// consultar
					String arquivo = JOptionPane.showInputDialog(null, "Infome o Código que deseja Consultar:");

					// Instância de um Objeto da Class java(BufferedReader
					// "Para Leitura do Arquivo"), que Instância um Objeto da
					// Class java(FileReader) referenciando o arquivo a ser
					// aberto.
					BufferedReader br = new BufferedReader(new FileReader(arquivo + ".txt"));

					// le o conteudo e passa paras as textfilds
					tfCodigo.setText(br.readLine());
					tfNome.setText(br.readLine());
					tfEmail.setText(br.readLine());
					cbCidade.setSelectedItem(br.readLine());
					tfBairro.setText(br.readLine());
					cbCurso.setSelectedItem(br.readLine());

					String logica = br.readLine();
					if (logica.equals(rbSim.getText())) {
						rbSim.setSelected(true);
					} else if (logica.equals(rbNao.getText())) {
						rbNao.setSelected(true);
					}

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Não foi possivel realizar a tarefa." + erro);

					limpar();
				}

			}
		});

	}

	public Cadastro() {
		inicializarComponentes();
		definirEventos();
	}
}
