package br.com.cadastroaluno.model;

public class Endereco {

	private int id;
	private String rua;
	private String bairro;
	private String cidade;

	public Endereco() {

	}

	public Endereco(int id, String rua, String bairro, String cidade) {
		super();
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
