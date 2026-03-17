package pedidovendas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import desconto.CalculadoraDescontoPrimeiraFaixa;
import desconto.CalculadoraDescontoSegundaFaixa;
import desconto.CalculadoraDescontoTerceiraFaixa;
import desconto.CalculadoraFaixaDesconto;
import desconto.CalculadoraSemDesconto;



public class PedidoTest {

	private Pedido pedido;


	@BeforeEach
	void setUp() {
		CalculadoraFaixaDesconto calculadoraFaixaDesconto = 
				new CalculadoraDescontoTerceiraFaixa(
						new CalculadoraDescontoSegundaFaixa(
								new CalculadoraDescontoPrimeiraFaixa(
										new CalculadoraSemDesconto(null))));
		pedido = new Pedido(calculadoraFaixaDesconto);
	}


	@Test
	void deveAdicionarUmItemNoPedido() {
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.00, 10));
	}

	
	@Test
	void deveCalcularValorTotalEDescontoParaPedidoVazio() {
		assertResumoPedido(0.00, 0.00);
	}


	protected void assertResumoPedido(double valorTotalEsperado, double valorDescontoEsperado) {
		ResumoPedido resumoPedido = pedido.resumo();
		assertEquals(valorTotalEsperado, resumoPedido.getValorTotal());
		assertEquals(valorDescontoEsperado, resumoPedido.getValorDesconto());
	}
	
	
	@Test
	void deveCalcularResumoPedidoParaUmItemSemDesconto() {
		pedido.adicionarItem(new ItemPedido("Sabonete", 5.00, 5));
		assertResumoPedido(25.00, 0.00);
	}

	
	
	@Test
	void deveCalcularResumoPedidoParaDoisItensSemDesconto() {
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.00, 3));
		pedido.adicionarItem(new ItemPedido("Creme dental", 7.00, 3));
		assertResumoPedido(30.00, 0.00);
	}

		
	@Test
	void deveCalcularDescontoDa1aFaixa() {
		pedido.adicionarItem(new ItemPedido("Creme", 20.00, 20));
		assertResumoPedido(400.00, 16.00);
	}
	
	
	@Test
	void deveCalcularDescontoDa2aFaixa() {
		pedido.adicionarItem(new ItemPedido("Xampu", 15.00, 30));
		pedido.adicionarItem(new ItemPedido("Óleo", 15.00, 30));
		assertResumoPedido(900.00, 54.00);
	}
	
	
	@Test
	void deveCalcularDescontoDa3aFaixa() {
		pedido.adicionarItem(new ItemPedido("Creme", 20.00, 15));
		pedido.adicionarItem(new ItemPedido("Xampu", 15.00, 30));
		pedido.adicionarItem(new ItemPedido("Óleo", 15.00, 30));
		assertResumoPedido(1200.00, 96.00);
	}
	
	
}
