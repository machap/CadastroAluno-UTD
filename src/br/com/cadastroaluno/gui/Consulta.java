package br.com.cadastroaluno.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import br.com.cadastroaluno.dao.AlunoDAO;
import br.com.cadastroaluno.model.Aluno;

public class Consulta extends Principal {

	private JLabel lbPesquisar;
	private JTextField tfPesquisar;
	private JButton btnConsultar, btnPesquisar;

	private JTable tbConsultaAluno;

	public Consulta() {

		setTitle("Consulta de Alunos");
		setSize(540, 430);
		getContentPane().setBackground(new Color(135, 206, 250));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		lbPesquisar = new JLabel("Consultar");
		lbPesquisar.setBounds(20, 30, 80, 25);
		getContentPane().add(lbPesquisar);

		tfPesquisar = new JTextField("Pesuise pelo Nome");
		tfPesquisar.setBounds(110, 30, 150, 25);
		getContentPane().add(tfPesquisar);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(280, 30, 110, 25);
		getContentPane().add(btnPesquisar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(400, 30, 110, 25);
		getContentPane().add(btnConsultar);
		
		miConsultar.setEnabled(false);

		tbConsultaAluno = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tbConsultaAluno);
		this.add(scrollPane);

		tbConsultaAluno.setModel(new DefaultTableModel(

				new Object[][] { { null, null, null, null, null, null, null, null } },
				new String[] { "ID", "NOME", "EMAIL", "RUA", "BAIRRO", "CIDADE", "CURSO", "LOGICA" }

		));

		tbConsultaAluno.setPreferredScrollableViewportSize(new Dimension(500, 400));
		tbConsultaAluno.setFillsViewportHeight(true);

		tbConsultaAluno.setBounds(20, 75, 490, 200);
		getContentPane().add(tbConsultaAluno);

		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel t = (DefaultTableModel) tbConsultaAluno.getModel();

				tbConsultaAluno.setRowSorter(new TableRowSorter(t));

				readJTable();

			}

			public void readJTable() {
				DefaultTableModel t = (DefaultTableModel) tbConsultaAluno.getModel();
				t.setNumRows(0);
				AlunoDAO dao = new AlunoDAO();

				for (Aluno a : dao.findId()) {

					t.addRow(new Object[] { a.getId(), a.getNome(), a.getEmail(), a.getRua(), a.getBairro(),
							a.getCidade(), a.getCurso(), a.isLogica()

					});
				}
			}

		});
	}
}