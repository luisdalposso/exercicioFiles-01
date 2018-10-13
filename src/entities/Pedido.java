package entities;

public class Pedido {

	private Integer qtd;
	private Produto produto;

	public Pedido(Integer qtd, Produto produto) {
		this.qtd = qtd;
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Double subTotal() {
		return qtd * produto.getValorUnit();
	}

	@Override
	public String toString() {
		return "PRODUTO: " + produto.getNome() + ", PREÇO UNITÁRIO: R$" + produto.getValorUnit() + ", SUBTOTAL: R$"
				+ subTotal();
	}

}
