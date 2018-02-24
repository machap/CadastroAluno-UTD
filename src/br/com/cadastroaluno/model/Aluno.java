package br.com.cadastroaluno.model;

public class Aluno {

	private int id;
	private String nome;
	private String email;
	private String rua;
	private String bairro;
	private String cidade;
	private String curso;
	private boolean logica;

	public Aluno() {

	}

	public Aluno(int id, String nome, String email, String rua, String bairro, String cidade, String curso, boolean logica) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.curso = curso;
		this.logica = logica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBairro() {
		return bairro;
	}

	public void setbairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(Object object) {
		this.cidade = (String) object;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(Object object) {
		this.curso = (String) object;
	}

	public boolean isLogica() {
		return logica;
	}

	public void setLogica(boolean logica) {
		this.logica = logica;
	}
	
	@Override
	public String toString() {
		return "[Nome: " + this.nome + ", " + this.email + " ]";
		
	}

}
