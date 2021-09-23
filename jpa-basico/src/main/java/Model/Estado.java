package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(
            mappedBy = "estado",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Aluno> alunos = new ArrayList<>();

    public Estado() {
    }

    public Estado(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Estado(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
