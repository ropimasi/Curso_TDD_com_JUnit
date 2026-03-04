import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CamelCaseConverterTest {
	private CamelCaseConverter camelCaseConverter;
	
	@BeforeEach
	public void setUp() {
		camelCaseConverter = new CamelCaseConverter();
	}
	
	@Test
	void Dado_uma_palavra_em_minusculo_Quando_converter_Entao_retornar_em_camelcase() {
		String palavra = "exemplo";
		String resultado = camelCaseConverter.converter(palavra);
		assertEquals("Exemplo", resultado);
	}
	
	@Test
	void Dado_uma_palavra_em_minusculo_e_maiusculo_misturado_Quando_converter_Entao_retornar_em_camelcase() {
		String palavra = "eXEmpLoS";
		String resultado = camelCaseConverter.converter(palavra);
		assertEquals("Exemplos", resultado);
	}
	
	@Test
	void Dado_duas_ou_mais_palavras_Quando_converter_Entao_retornar_em_camelcase() {
		String palavra = "uma duas palavras";
		String resultado = camelCaseConverter.converter(palavra);
		assertEquals("Uma Duas Palavras", resultado);
	}
	
	
	
}
