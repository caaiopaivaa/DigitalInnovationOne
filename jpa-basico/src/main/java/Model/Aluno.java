package Model;

import javax.persistence.*;

@Entity(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private int idade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;

    public Aluno(int id, String nome, int idade, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    public Aluno(String nome, int idade, Estado estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    public Aluno() {
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", estado=" + estado +
                '}';
    }
}
