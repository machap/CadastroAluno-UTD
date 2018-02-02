package br.com.cadastroaluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cadastroaluno.connection.ConnectionFactory;
import br.com.cadastroaluno.model.Aluno;

public class AlunoDAO {

	private Connection con = null;

	public AlunoDAO() {

		con = ConnectionFactory.getConnection();
	}

	public boolean insert(Aluno aluno) {

		String sql = "INSERT INTO tbAluno(matricula, nome, email, idEndereco, idCurso) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getEmail());
			stmt.setInt(4, aluno.getEndereco().getId());
			stmt.setInt(5, aluno.getCurso().getId());
			stmt.executeUpdate();

			return true;
		} catch (SQLException ex) {
			
			System.err.println("Erro: " + ex);
			
			return false;
			
		} finally {
			
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
