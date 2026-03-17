package desconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraDescontoSegundaFaixaTest {
	
	private static final double PORCENTAGEM_DESCONTO_SEGUNDA_FAIXA = 0.06;

	@Test
	public void deveCalcularDescontoSegundaFaixa() {
		CalculadoraFaixaDesconto calculadoraSemDesconto = new CalculadoraSemDesconto(null);
		CalculadoraFaixaDesconto calculadoraPrimeiraFaixa = new CalculadoraDescontoPrimeiraFaixa(calculadoraSemDesconto);
		CalculadoraFaixaDesconto calculadoraSegundaFaixa = new CalculadoraDescontoSegundaFaixa(calculadoraPrimeiraFaixa);

		double valorTotal = 900.00;
		double valorDescontoEsperado = valorTotal * PORCENTAGEM_DESCONTO_SEGUNDA_FAIXA;
		double valorDescontoCalculado = calculadoraSegundaFaixa.calcularDesconto(valorTotal);

		Assertions.assertEquals(valorDescontoEsperado, valorDescontoCalculado, "O valor de desconto calculado para a segunda faixa deve ser 6% do valor total.");
	}
	
}
