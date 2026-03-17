package desconto;

public class CalculadoraDescontoSegundaFaixa extends CalculadoraFaixaDesconto {

	public CalculadoraDescontoSegundaFaixa(CalculadoraFaixaDesconto proximoCalculador) {
		super(proximoCalculador);
	}


	@Override
	protected double calcularDesconto(double valorTotal) {
		if (valorTotal > 800.00 && valorTotal <= 1000.00)
			return valorTotal * 0.06;

		return -1.00;
	}

}
