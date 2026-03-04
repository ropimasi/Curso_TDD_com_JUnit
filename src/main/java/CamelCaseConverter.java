
public class CamelCaseConverter {

	public String converter(String frase) {
		String[] palavras = frase.split(" ");

		for (String palavra : palavras) {
			frase = frase.replace(palavra, converterPalavra(palavra));
		}

		return frase;
	}


	private String converterPalavra(String palavra) {
		String primeiraLetra = palavra.substring(0, 1).toUpperCase();
		String restante = palavra.substring(1).toLowerCase();
		return primeiraLetra + restante;
	}

}
