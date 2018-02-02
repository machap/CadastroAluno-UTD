package br.com.cadastroaluno.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.cadastroaluno.model.Aluno;
import br.com.cadastroaluno.model.Curso;
import br.com.cadastroaluno.model.Endereco;

class AlunoTeste {

	@Test
	void testInsert() {
	
		Endereco endereco = new Endereco();
		endereco.setId(1);
	
		Curso curso = new Curso();
		curso.setId(1);
		
		Aluno aluno = new Aluno();		
		AlunoDAO dao = new AlunoDAO();
		
		aluno.setMatricula(2018);
		aluno.setNome("Paulo");
		aluno.setEmail("teste@email.com");
		aluno.setEndereco(endereco);
		aluno.setCurso(curso);
		
		if (dao.insert(aluno)) {
			System.out.println("Salvo com sucesso!");
		}else {
			fail("Erro ao Salvar");
		}
		
	}

}
