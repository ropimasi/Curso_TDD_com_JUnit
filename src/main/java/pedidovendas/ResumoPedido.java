package pedidovendas;

import java.util.Objects;



public class ResumoPedido {

	private Double valorTotal;
	private Double valorDesconto;


	public ResumoPedido(Double valorTotal, Double valorDesconto) {
		super();
		this.valorTotal = valorTotal;
		this.valorDesconto = valorDesconto;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Double getValorDesconto() {
		return valorDesconto;
	}


	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}


	@Override
	public int hashCode() {
		return Objects.hash(valorDesconto, valorTotal);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResumoPedido other = (ResumoPedido) obj;
		return Objects.equals(valorDesconto, other.valorDesconto) && Objects.equals(valorTotal, other.valorTotal);
	}


	@Override
	public String toString() {
		return "ResumoPedido [valorTotal=" + valorTotal + ", valorDesconto=" + valorDesconto + "]";
	}

}
