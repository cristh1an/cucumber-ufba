package cucumber.modelo;

public class Estudante {
    private String nome;
    private int id;
    private double nota;

    public Estudante(String nome, int id, double nota) {
        this.nome = nome;
        this.id = id;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", ID: " + id + ", Nota: " + nota;
    }
}
