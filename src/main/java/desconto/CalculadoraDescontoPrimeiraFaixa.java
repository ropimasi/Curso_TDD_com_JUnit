package desconto;

public class CalculadoraDescontoPrimeiraFaixa extends CalculadoraFaixaDesconto {

	public CalculadoraDescontoPrimeiraFaixa(CalculadoraFaixaDesconto proximoCalculador) {
		super(proximoCalculador);
	}


	@Override
	protected double calcularDesconto(double valorTotal) {
		if (valorTotal > 300.00 && valorTotal <= 800.00)
			return valorTotal * 0.04;

		return -1.00;
	}

}
