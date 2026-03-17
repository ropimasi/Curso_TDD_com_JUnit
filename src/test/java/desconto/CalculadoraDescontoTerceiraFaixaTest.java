package desconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraDescontoTerceiraFaixaTest {
	
	private static final double PORCENTAGEM_DESCONTO_TERCEIRA_FAIXA = 0.08;

	@Test
	public void deveCalcularDescontoTerceiraFaixa() {
		CalculadoraFaixaDesconto calculadoraSemDesconto = new CalculadoraSemDesconto(null);
		CalculadoraFaixaDesconto calculadoraPrimeiraFaixa = new CalculadoraDescontoPrimeiraFaixa(calculadoraSemDesconto);
		CalculadoraFaixaDesconto calculadoraSegundaFaixa = new CalculadoraDescontoSegundaFaixa(calculadoraPrimeiraFaixa);
		CalculadoraFaixaDesconto calculadoraTerceiraFaixa = new CalculadoraDescontoTerceiraFaixa(calculadoraSegundaFaixa);

		double valorTotal = 1500.00;
		double valorDescontoEsperado = valorTotal * PORCENTAGEM_DESCONTO_TERCEIRA_FAIXA;
		double valorDescontoCalculado = calculadoraTerceiraFaixa.calcularDesconto(valorTotal);
		
		Assertions.assertEquals(valorDescontoEsperado, valorDescontoCalculado, "O valor de desconto calculado para a terceira faixa deve ser 8% do valor total.");
	}
}
