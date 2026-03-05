package pedidovendas;

import java.util.ArrayList;
import java.util.List;



public class Pedido {

	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();


	public void adicionarItem(ItemPedido itemPedido) {
		itensPedido.add(itemPedido);
	}
	
	
	public ResumoPedido resumo() {
		double valorTotal = itensPedido.stream()
				.mapToDouble(item -> item.getValorUnitario() * item.getQuantidade())
				.sum();
		
		double valorDesconto = 0.00;
		if (valorTotal > 1000.00) {
			valorDesconto = valorTotal * 0.08;
		} else if (valorTotal > 800.00) {
			valorDesconto = valorTotal * 0.06;
		} else if (valorTotal > 300.00) {
			valorDesconto = valorTotal * 0.04;
		}
		
		return new ResumoPedido(valorTotal, valorDesconto);
	}

}
