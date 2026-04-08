package pedidovendas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import desconto.CalculadoraDescontoPrimeiraFaixa;
import desconto.CalculadoraDescontoSegundaFaixa;
import desconto.CalculadoraDescontoTerceiraFaixa;
import desconto.CalculadoraFaixaDesconto;
import desconto.CalculadoraSemDesconto;



public class PedidoTest {

	private PedidoBuilder pedidoBuilder;


	@BeforeEach
	void setUp() {
		pedidoBuilder = new PedidoBuilder();
	}


	@Test
	void deveAdicionarUmItemNoPedido() {
		pedidoBuilder.comItem(3.00, 10);
	}

	
	@Test
	void deveCalcularValorTotalEDescontoParaPedidoVazio() {
		assertResumoPedido(0.00, 0.00);
	}


	protected void assertResumoPedido(double valorTotalEsperado, double valorDescontoEsperado) {
		ResumoPedido resumoPedido = pedidoBuilder.construir().resumo();
		//assertEquals(valorTotalEsperado, resumoPedido.getValorTotal());
		//assertEquals(valorDescontoEsperado, resumoPedido.getValorDesconto());
		assertEquals(new ResumoPedido(valorTotalEsperado, valorDescontoEsperado), resumoPedido);
	}
	
	
	@Test
	void deveCalcularResumoPedidoParaUmItemSemDesconto() {
		pedidoBuilder.comItem(5.00, 5);
		assertResumoPedido(25.00, 0.00);
	}

	
	
	@Test
	void deveCalcularResumoPedidoParaDoisItensSemDesconto() {
		pedidoBuilder.comItem(3.00, 3)
				.comItem(7.00, 3);
		assertResumoPedido(30.00, 0.00);
	}

		
	@Test
	void deveCalcularDescontoDa1aFaixa() {
		pedidoBuilder.comItem(20.00, 20);
		assertResumoPedido(400.00, 16.00);
	}
	
	
	@Test
	void deveCalcularDescontoDa2aFaixa() {
		pedidoBuilder.comItem(15.00, 30)
				.comItem(15.00, 30);
		assertResumoPedido(900.00, 54.00);
	}
	
	
	@Test
	void deveCalcularDescontoDa3aFaixa() {
		pedidoBuilder.comItem(20.00, 15)
				.comItem(15.00, 30)
				.comItem(15.00, 30);
		assertResumoPedido(1200.00, 96.00);
	}
	
	@Test
	void deveLancarExceceoParaQuantidadeItemPedidoNegativo() {
		Assertions.assertThrows(QuantidadeItemInvalidaException.class,
				() -> pedidoBuilder.comItem(1.00, -10));
	}
	
	
}
