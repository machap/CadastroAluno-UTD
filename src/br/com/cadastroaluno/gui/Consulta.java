package br.com.cadastroaluno.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import br.com.cadastroaluno.connection.ConnectionFactory;
import br.com.cadastroaluno.dao.AlunoDAO;
import br.com.cadastroaluno.model.Aluno;

public class Consulta extends Principal {

	private JLabel lbPesquisar;
	private JTextField tfPesquisar;
	private JButton btnConsultar, btnPesquisar;

	private JTable tbConsultaAluno;

	@SuppressWarnings("unused")
	public Consulta() {

		setTitle("Consulta de Alunos");
		setSize(540, 430);
		getContentPane().setBackground(new Color(135, 206, 250));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		lbPesquisar = new JLabel("Consultar");
		lbPesquisar.setBounds(20, 30, 80, 25);
		getContentPane().add(lbPesquisar);

		tfPesquisar = new JTextField();
		tfPesquisar.setBounds(110, 30, 150, 25);
		getContentPane().add(tfPesquisar);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(280, 30, 110, 25);
		getContentPane().add(btnPesquisar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(400, 30, 110, 25);
		getContentPane().add(btnConsultar);

		miConsultar.setEnabled(false);

		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id = 0;

				
				try {
					if (tfPesquisar.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "O Campo Pesquisa não pode está vazio!");
						tfPesquisar.requestFocus();
					} else {
						id = Integer.parseInt(tfPesquisar.getText());
					}

				} catch (NumberFormatException numberFormatException) {
					JOptionPane.showMessageDialog(null, "O Campo Pesquisa só aceita numeros");
				}
				
				Cadastro c = new Cadastro();
				
				Aluno aluno = new Aluno();
				AlunoDAO  dao = new AlunoDAO();;
				
				aluno = dao.retornaDados(id);

				c.tfNome.setText(aluno.getNome());
				c.tfEmail.setText(aluno.getEmail());
				c.tfRua.setText(aluno.getRua());
				c.tfBairro.setText(aluno.getBairro());
				c.cbCidade.setSelectedItem(aluno.getCidade());
				c.cbCurso.setSelectedItem(aluno.getCurso());
				if(aluno.isLogica() == true){
					c.rbSim.setSelected(true);
				}else{
					c.rbNao.setSelected(true);
				}

				c.setVisible(true);				

				c.btnEditar.setEnabled(true);

			}

		});

		tbConsultaAluno = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tbConsultaAluno);
		this.add(scrollPane);

		tbConsultaAluno.setModel(new DefaultTableModel(

				new Object[][] { { "ID", "NOME", "EMAIL", "RUA", "BAIRRO", "CIDADE", "CURSO", "LOGICA" } },

				new String[] { null, null, null, null, null, null, null, null, null }

		));

		tbConsultaAluno.setBounds(20, 75, 490, 280);
		getContentPane().add(tbConsultaAluno);

		tbConsultaAluno.addMouseListener(new MouseAdapter() {

		});


		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel t = (DefaultTableModel) tbConsultaAluno.getModel();

				tbConsultaAluno.setRowSorter(new TableRowSorter(t));

				readJTable();

			}

			public void readJTable() {
				DefaultTableModel t = (DefaultTableModel) tbConsultaAluno.getModel();
				t.setNumRows(1);

				AlunoDAO dao = new AlunoDAO();

				for (Aluno a : dao.buscarTodos()) {

					t.addRow(new Object[] { a.getId(), a.getNome(), a.getEmail(), a.getRua(), a.getBairro(),
							a.getCidade(), a.getCurso(), a.isLogica()

					});

				}
			}

		});
	}
}