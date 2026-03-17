package desconto;

public class CalculadoraDescontoTerceiraFaixa extends CalculadoraFaixaDesconto {

	public CalculadoraDescontoTerceiraFaixa(CalculadoraFaixaDesconto proximoCalculador) {
		super(proximoCalculador);
	}


	@Override
	protected double calcularDesconto(double valorTotal) {
		if (valorTotal > 1000.00)
			return valorTotal * 0.08;

		return -1.00;
	}

}
