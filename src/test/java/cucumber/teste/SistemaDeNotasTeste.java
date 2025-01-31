package cucumber.teste;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/caracteristicas/", tags = "@SistemaDeNotas", glue = "cucumber.teste.passos", monochrome = true, dryRun = false)
public class SistemaDeNotasTeste {

}