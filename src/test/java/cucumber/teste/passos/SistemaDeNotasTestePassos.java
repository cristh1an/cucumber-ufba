package cucumber.teste.passos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import cucumber.modelo.Estudante;
import cucumber.modelo.SistemaDeNotas;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Mas;
import io.cucumber.java.pt.Quando;

public class SistemaDeNotasTestePassos {

	private SistemaDeNotas sistema;
	private double notaAprovacao;
	
    @Before("@comDados")
    public void setupTestesComDados() {
    	sistema = new SistemaDeNotas();
    	sistema.adicionarEstudante("Cristhian", 3.0);
    	sistema.adicionarEstudante("Robson", 6.0);
    	sistema.adicionarEstudante("Alan", 9.0);
    }
	
    @Dado("o sistema inicializado")
    public void sistema_inicializado() throws Throwable {
          // Definição de conta
          sistema = new SistemaDeNotas();
    }
    
    @Dado("nota aprovação é {double}")
    public void nota_aprovacao(double notaAprovacao) {
    	this.notaAprovacao = notaAprovacao;
    }
    
    @Entao("o sistema possui {int} estudantes cadastrados")
    public void sistema_sem_aluno_cadastrado(int quantidade_alunos) {
    	assertEquals(quantidade_alunos, sistema.obterNumeroDeEstudantes());
    }
    
    @Quando("eu adiciono um estudante com nome {string} e nota {double}")
    public void adicionar_aluno(String nome, double nota) {
    	sistema.adicionarEstudante(nome, nota);
    }
    
    @E("removo o estudante {string}")
    public void removo_estudante(String nome) {
    	Estudante e = sistema.encontrarEstudantePorNome(nome);
    	sistema.deletarEstudante(e.getId());
    }
    
    @Entao("deve existir estudante com nome {string}")
    public void existe_estudante(String nome) {
    	Estudante e = sistema.encontrarEstudantePorNome(nome);
    	assertNotNull(e);
    }
    
    
    @Mas("não deve existir estudante com nome {string}")
    public void nao_existe_estudante(String nome) {
    	Estudante e = sistema.encontrarEstudantePorNome(nome);
    	assertNull(e);	
    }
    
    @E("altero a nota do aluno com id {int} para {double}")
    public void altero_nota(int id, double nota) {
    	sistema.atualizarNotaDoEstudante(id,  6.5);
    }
    
    @Entao("a média de notas deve ser {double}")
    public void media_deve_ser(double media) {
    	double calcMedia = sistema.calcularMediaDasNotas();
    	assertEquals(media, calcMedia, 0);
    }
    
    @Entao("o aluno com id {int} deve ter nome {string} e nota {double}")
    public void aluno_id_nome(int id, String nome, double nota) {
    	Estudante e = sistema.visualizarEstudante(id);
    	assertEquals(nome, e.getNome());
    	assertEquals(nota, e.getNota(), 0);
    }
    
    @Entao("estudante {string} deve estar aprovado")
    public void aprovado(String nome) {
    	assertTrue(sistema.estaAprovado(nome, this.notaAprovacao));
    }
    
    @Mas("estudante {string} deve estar reprovado")
    public void reprovado(String nome) {
    	assertFalse(sistema.estaAprovado(nome, this.notaAprovacao));
    }
    
    @Quando("apago todos os estudantes")
    public void apagar_estudantes() {
    	sistema.limparTodosOsEstudantes();
    }
    
    @Quando("^eu adiciono um estudante com nome \"(.*?)\" e nota (\\d+)$")
    public void adicionar_aluno_regex(String nome, double nota){
    	sistema.adicionarEstudante(nome, nota);
    }
    
    
}
