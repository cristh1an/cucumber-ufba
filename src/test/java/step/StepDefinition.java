package step;




import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class StepDefinition {
	
	private boolean teste;

	@Dado("Eu tenho um teste")
	public void tenhoTest() {
		this.teste = true;
	}
	
	@Entao("Verdade eh verdade")
	public void ehVerdade() {
		assertTrue(this.teste);
	}
	
}
