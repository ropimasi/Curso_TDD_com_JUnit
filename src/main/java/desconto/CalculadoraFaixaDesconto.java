package desconto;

public abstract class CalculadoraFaixaDesconto {

	private CalculadoraFaixaDesconto proximoCalculador;


	public CalculadoraFaixaDesconto(CalculadoraFaixaDesconto proximoCalculador) {
		this.proximoCalculador = proximoCalculador;
	}


	public double desconto(double valorTotal) {
		double valorDesconto = calcularDesconto(valorTotal);
		
		if (valorDesconto == -1.00)
			return proximoCalculador.desconto(valorTotal);
		
		return valorDesconto;
	}

	
	protected abstract double calcularDesconto(double valorTotal);
}
