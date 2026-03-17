package desconto;

public class CalculadoraSemDesconto extends CalculadoraFaixaDesconto {

	public CalculadoraSemDesconto(CalculadoraFaixaDesconto proximoCalculador) {
		super(proximoCalculador);
	}


	@Override
	protected double calcularDesconto(double valorTotal) {
		return 0.00;
	}

}
