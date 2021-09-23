import java.util.List;

public class Main {
    public static void main(String[] args) {
/*        List<Aluno> alunos= AlunoDAO.list();
        alunos.stream().forEach(System.out::println);*/
        //Aluno aluno = AlunoDAO.getById(3);
        //System.out.println(aluno);
/*        Aluno aluno = new Aluno(5,"Caio", 40 , "RN");
        AlunoDAO.update(aluno);*/
        /*AlunoDAO.create(aluno);*/
        AlunoDAO.delete(6);


    }
}
