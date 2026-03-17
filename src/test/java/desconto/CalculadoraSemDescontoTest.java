package desconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraSemDescontoTest {
	
	@Test
	public void deveCalcularDescontoZero() {
		CalculadoraFaixaDesconto calculadoraSemDesconto = new CalculadoraSemDesconto(null);

		double valorTotal = 100.00;
		double desconto = calculadoraSemDesconto.calcularDesconto(valorTotal);

		Assertions.assertEquals(0.00, desconto, "O desconto deve ser zero para a calculadora sem desconto.");
	}
}
