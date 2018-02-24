package br.com.cadastroaluno.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.cadastroaluno.dao.AlunoDAO;
import br.com.cadastroaluno.model.Aluno;

public class Cadastro extends Principal {

	private JLabel lbApresentação, lbRua, lbNome, lbEmail, lbCidade, lbBairro, lbCurso, lbFoto, lbLogica;
	protected JTextField tfRua, tfNome, tfEmail, tfBairro;
	protected JButton btnConcluir, btnEditar, btnLimpar;
	JComboBox cbCidade;
	JComboBox cbCurso;
	JRadioButton rbSim;
	JRadioButton rbNao;
	private ButtonGroup bgLogica;

	public void limpar() {

		tfRua.setText("");
		tfNome.setText("");
		tfEmail.setText("");
		cbCidade.setSelectedIndex(0);
		tfBairro.setText("");
		cbCurso.setSelectedIndex(0);
		bgLogica.clearSelection();
	}

	public Cadastro() {

		// Define um titulo para o Frame
		setTitle("Cadastro de Alunos");
		// Define o tamanho do frame
		setSize(540, 430);
		//
		getContentPane().setBackground(new Color(135, 206, 250));
		// Define a Localização
		setLocationRelativeTo(null);
		// Encerra a aplicação quando é fechada
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// Instancia dos objetos, Label TextFild e Button
		lbApresentação = new JLabel("Insira as informações abaixo para se inscrever");
		lbRua = new JLabel("Rua");
		lbNome = new JLabel("Nome");
		lbEmail = new JLabel("Email");
		lbCidade = new JLabel("Cidade");
		lbBairro = new JLabel("Bairro");
		lbCurso = new JLabel("Curso");
		lbFoto = new JLabel("Foto");
		lbLogica = new JLabel("Você sabe logica de programação ?");

		tfRua = new JTextField();
		tfNome = new JTextField();
		tfEmail = new JTextField();
		tfBairro = new JTextField();

		btnConcluir = new JButton("Concluir");
		btnEditar = new JButton("Editar");
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
		lbApresentação.setBounds(100, 10, 400, 20);

		lbNome.setBounds(20, 45, 50, 20);
		lbEmail.setBounds(20, 75, 50, 20);
		lbRua.setBounds(20, 110, 50, 20);
		lbBairro.setBounds(20, 145, 50, 20);
		lbCidade.setBounds(20, 180, 50, 20);
		lbCurso.setBounds(20, 215, 50, 20);
		lbFoto.setBounds(400, 250, 50, 20);
		lbLogica.setBounds(20, 250, 250, 20);
		tfRua.setBounds(100, 45, 50, 25);

		tfNome.setBounds(100, 45, 200, 25);
		tfEmail.setBounds(100, 75, 200, 25);
		tfRua.setBounds(100, 110, 200, 25);
		tfBairro.setBounds(100, 145, 200, 20);
		cbCidade.setBounds(100, 180, 200, 25);
		cbCurso.setBounds(100, 215, 200, 20);

		btnConcluir.setBounds(90, 310, 100, 30);
		btnEditar.setBounds(220, 310, 110, 30);
		btnLimpar.setBounds(360, 310, 100, 30);

		rbSim.setBounds(40, 275, 60, 20);
		rbNao.setBounds(120, 275, 60, 20);

		// Adiciona os componenetes na Frame
		getContentPane().add(lbApresentação);
		getContentPane().add(lbRua);
		getContentPane().add(lbNome);
		getContentPane().add(lbCidade);
		getContentPane().add(lbBairro);
		getContentPane().add(lbCurso);
		getContentPane().add(lbFoto);
		getContentPane().add(lbEmail);
		getContentPane().add(lbLogica);

		getContentPane().add(tfRua);
		getContentPane().add(tfNome);
		getContentPane().add(tfEmail);
		getContentPane().add(tfBairro);

		getContentPane().add(btnConcluir);
		getContentPane().add(btnEditar);
		getContentPane().add(btnLimpar);

		getContentPane().add(cbCidade);
		getContentPane().add(cbCurso);

		getContentPane().add(rbSim);
		getContentPane().add(rbNao);

		bgLogica.add(rbSim);
		bgLogica.add(rbNao);

		btnEditar.setEnabled(false);
		miCadastra.setEnabled(false);

		JPanel painelFoto = new JPanel();
		painelFoto.setBounds(350, 95,120, 145);
		this.getContentPane().add(painelFoto);
		painelFoto.setBackground(Color.DARK_GRAY);
		

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

				if (tfNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O Nome não pode está vazio!");

					tfNome.requestFocus();
				} else if (tfRua.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O Código não pode está vazio!");
					// Coloca o cursor na caixa de texto correspondente
					tfRua.requestFocus();
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

					Aluno aluno = new Aluno();
					AlunoDAO dao = new AlunoDAO();

					aluno.setNome(tfNome.getText());
					aluno.setEmail(tfEmail.getText());
					aluno.setRua(tfRua.getText());
					aluno.setbairro(tfBairro.getText());
					aluno.setCidade(cbCidade.getSelectedItem());
					aluno.setCurso(cbCurso.getSelectedItem());
					if (rbSim.isSelected()) {
						aluno.setLogica(true);
					} else {
						aluno.setLogica(false);
					}

					if (dao.inserir(aluno)) {
						JOptionPane.showMessageDialog(null, "Alunos Cadastrado com Sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possivel salvar");
					}

				}

			}
		});

	}

}
