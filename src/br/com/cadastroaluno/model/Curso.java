package br.com.cadastroaluno.model;

public class Curso {

	private int id;
	private String curso;
	private boolean logica;

	public Curso() {

	}

	public Curso(int id, String curso, boolean logica) {
		super();
		this.id = id;
		this.curso = curso;
		this.logica = logica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public boolean isLogica() {
		return logica;
	}

	public void setLogica(boolean logica) {
		this.logica = logica;
	}

}
