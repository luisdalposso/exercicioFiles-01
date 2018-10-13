package entities;

public class Produto {

	private String nome;
	private Double valorUnit;

	public Produto() {
	}

	public Produto(String nome, Double valorUnit) {
		this.nome = nome;
		this.valorUnit = valorUnit;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorUnit() {
		return valorUnit;
	}

}
