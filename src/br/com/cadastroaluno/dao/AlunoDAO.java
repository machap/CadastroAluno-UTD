package br.com.cadastroaluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.cadastroaluno.connection.ConnectionFactory;
import br.com.cadastroaluno.model.Aluno;

public class AlunoDAO {

	private Connection con = null;

	public AlunoDAO() {

		con = ConnectionFactory.getConnection();
	}

	public boolean insert(Aluno aluno) {

		String sql = "INSERT INTO tbAlunoDados(nome, email, rua, bairro, cidade, curso, logica) VALUES (?,?,?,?,?,?,?)";

		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setString(3, aluno.getRua());
			stmt.setString(4, aluno.getBairro());
			stmt.setString(5, aluno.getCidade());
			stmt.setString(6, aluno.getCurso());
			stmt.setBoolean(7, aluno.isLogica());

			stmt.executeUpdate();

			return true;
		} catch (SQLException ex) {

			System.err.println("Erro: " + ex);

			return false;

		} finally {

			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Aluno> findAll(int id) {

		String sql = "SELECT * FROM tbAlunoDados WHERE id = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Aluno> alunos = new ArrayList<>();

		try {

			Aluno aluno = new Aluno();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			rs.next();
			aluno.setNome(rs.getString("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setEmail(rs.getString("email"));
			aluno.setRua(rs.getString("rua"));
			aluno.setbairro(rs.getString("bairro"));
			aluno.setCidade(rs.getObject("cidade"));
			aluno.setCurso(rs.getObject("curso"));
			aluno.setLogica(rs.getBoolean("logica"));

			alunos.add(aluno);

		} catch (SQLException ex) {
			System.err.println("Erro: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return alunos;

	}

	public List<Aluno> findId() {

		String sql = "SELECT * FROM tbAlunoDados";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Aluno> alunos = new ArrayList<>();

		try {

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Aluno aluno = new Aluno();

				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setRua(rs.getString("rua"));
				aluno.setbairro(rs.getString("bairro"));
				aluno.setCidade(rs.getObject("cidade"));
				aluno.setCurso(rs.getObject("curso"));
				aluno.setLogica(rs.getBoolean("logica"));

				alunos.add(aluno);
			}
		} catch (SQLException ex) {
			System.err.println("Erro: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return alunos;

	}

}
