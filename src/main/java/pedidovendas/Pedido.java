package pedidovendas;

import java.util.ArrayList;
import java.util.List;
import desconto.CalculadoraFaixaDesconto;



public class Pedido {

	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

	private CalculadoraFaixaDesconto calculadoraFaixaDesconto;


	public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
		this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
	}


	public void adicionarItem(ItemPedido itemPedido) {
		validarQuantidadeItemPedido(itemPedido);
		itensPedido.add(itemPedido);
	}


	protected void validarQuantidadeItemPedido(ItemPedido itemPedido) {
		if (itemPedido.getQuantidade() < 0) {
            throw new QuantidadeItemInvalidaException();
        }
	}


	public ResumoPedido resumo() {
		double valorTotal = itensPedido.stream().mapToDouble(item -> item.getValorUnitario() * item.getQuantidade())
				.sum();

		double valorDesconto = calculadoraFaixaDesconto.desconto(valorTotal);

		return new ResumoPedido(valorTotal, valorDesconto);
	}

}
