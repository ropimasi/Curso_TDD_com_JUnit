package desconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraDescontoPrimeiraFaixaTest {
	
	private static final double PORCENTAGEM_DESCONTO_PRIMEIRA_FAIXA = 0.04;

	@Test
	public void deveCalcularDescontoPrimeiraFaixa() {
		CalculadoraFaixaDesconto calculadoraSemDesconto = new CalculadoraSemDesconto(null);
		CalculadoraFaixaDesconto calculadoraPrimeiraFaixa = new CalculadoraDescontoPrimeiraFaixa(
				calculadoraSemDesconto);

		double valorTotal = 500.00;
		double valorDescontoEsperado = valorTotal * PORCENTAGEM_DESCONTO_PRIMEIRA_FAIXA;
		double valorDescontoCalculado = calculadoraPrimeiraFaixa.calcularDesconto(valorTotal);

		Assertions.assertEquals(valorDescontoEsperado, valorDescontoCalculado, "O valor de desconto calculado para a primeira faixa deve ser 4% do valor total.");
	}
	
}
