package cucumber.modelo;

import java.util.ArrayList;
import java.util.List;


public class SistemaDeNotas {
    private List<Estudante> estudantes = new ArrayList<>();

    // Operações CRUD (Sem interação com o usuário)

    public void adicionarEstudante(String nome, double nota) {
    	int tamLista = estudantes.size();
    	int id = tamLista + 1;
        estudantes.add(new Estudante(nome, id, nota));
    }

    public Estudante visualizarEstudante(int id) {
        for (Estudante estudante : estudantes) {
            if (estudante.getId() == id) {
                return estudante;
            }
        }
        return null;
    }

    public void atualizarNotaDoEstudante(int id, double nota) {
        Estudante estudante = visualizarEstudante(id); // Reutiliza o método visualizarEstudante
        if (estudante != null) {
            estudante.setNota(nota);  
        }
    }

    public void deletarEstudante(int id) {
        estudantes.removeIf(estudante -> estudante.getId() == id);
    }

    public List<Estudante> visualizarTodosOsEstudantes() {
        return new ArrayList<>(estudantes); // Retorna uma cópia para evitar modificação
    }

    // Outros Métodos Auxiliares (Sem interação com o usuário)

    public Estudante encontrarEstudantePorNome(String nome) {
        for (Estudante estudante : estudantes) {
            if (estudante.getNome().equalsIgnoreCase(nome)) {
                return estudante;
            }
        }
        return null;
    }

    public double calcularMediaDasNotas() {
        if (estudantes.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (Estudante estudante : estudantes) {
            soma += estudante.getNota();
        }
        return soma / estudantes.size();
    }

    public int obterNumeroDeEstudantes() {
        return estudantes.size();
    }

    public void limparTodosOsEstudantes() {
        estudantes.clear();
    }

    public void adicionarMultiplosEstudantes(List<Estudante> novosEstudantes) {
        estudantes.addAll(novosEstudantes);
    }

    public List<Estudante> obterEstudantesAprovados(double limiar) {
        List<Estudante> aprovados = new ArrayList<>();
        for (Estudante estudante : estudantes) {
            if (estudante.getNota() > limiar) {
                aprovados.add(estudante);
            }
        }
        return aprovados;
    }
    
    public boolean estaAprovado(String nome, double notaAprovacao) {
    	List<Estudante> estudantesAprovados = obterEstudantesAprovados(notaAprovacao);
    	for (Estudante estudante : estudantesAprovados) {
    		if(estudante.getNome().equals(nome)) {
    			return true;
    		}
    	}
    	return false;
    }

}
