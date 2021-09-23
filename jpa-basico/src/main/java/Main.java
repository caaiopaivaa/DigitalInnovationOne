import Model.Aluno;
import Model.Estado;

import javax.persistence.*;

import javax.persistence.PersistenceContext;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Estado estado = new Estado(1,"PE");
//        Aluno aluno = new Aluno("Marcelo",55,estado);
//        //Aluno aluno2 = new Aluno("Joao",40,estado);
        entityManager.getTransaction().begin();

        Estado estado = entityManager.find(Estado.class, 1);
        Aluno aluno = entityManager.find(Aluno.class, 5);
        System.out.println(estado);
        System.out.println(aluno);
        //entityManager.persist(estado);
//        entityManager.persist(aluno);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();



    }
}
