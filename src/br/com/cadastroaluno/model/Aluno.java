package br.com.cadastroaluno.model;

public class Aluno {

	private int id;
	private int matricula;
	private String nome;
	private String email;
	private Endereco endereco;
	private Curso curso;

	public Aluno() {

	}

	public Aluno(int id, int matricula, String nome, String email, Endereco endereco, Curso curso) {
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
