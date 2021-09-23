import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    // consulta
    public static List<Aluno> list(){
        List<Aluno> alunos = new ArrayList<>();

        try(Connection con = ConnectionFactory.getConnection()){
            PreparedStatement prst = con.prepareStatement("SELECT * FROM aluno");
            ResultSet rs = prst.executeQuery();
            while(rs.next()){
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("estado")
                );
                alunos.add(aluno);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return alunos;

    }

    // consulta com filtro
    public static Aluno getById(int id){
        Aluno aluno = new Aluno();

        try(Connection con = ConnectionFactory.getConnection()){
            PreparedStatement prst = con.prepareStatement(
                    "SELECT * FROM aluno WHERE id=?");
            prst.setInt(1,id);
            ResultSet rs = prst.executeQuery();
            if (rs.next()){
                    aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("estado")
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return aluno;
    }

    // inserção
    public static void create(Aluno aluno){
        try(Connection con = ConnectionFactory.getConnection()){
            PreparedStatement prst = con.prepareStatement(
                    "INSERT INTO aluno(nome, idade, estado) " +
                            "VALUES(?,?,?)");
            prst.setString(1, aluno.getNome());
            prst.setInt(2, aluno.getIdade());
            prst.setString(3, aluno.getEstado());
            int rowsAffected = prst.executeUpdate();
            System.out.println(aluno+" inserido com sucesso. "+rowsAffected+
                    " linhas afetadas.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //delete
    public static void delete(int id){
        try(Connection con = ConnectionFactory.getConnection()){
            PreparedStatement prst = con.prepareStatement("DELETE FROM aluno WHERE id=?");
            prst.setInt(1, id);
            int rowsAffected = prst.executeUpdate();
            System.out.println("Registro removido com sucesso. "+rowsAffected+
                    " linhas afetadas.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //atualizar
    public static void update(Aluno aluno){

        try(Connection con = ConnectionFactory.getConnection()){
            PreparedStatement prst = con.prepareStatement(
                    "UPDATE aluno SET nome=?, idade=?, estado=? WHERE id=?");
            prst.setString(1, aluno.getNome());
            prst.setInt(2, aluno.getIdade());
            prst.setString(3, aluno.getEstado());
            prst.setInt(4, aluno.getId());
            int rowsAffected = prst.executeUpdate();
            System.out.println("Registro atualizado com sucesso. "+rowsAffected+
                    " linhas afetadas.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
