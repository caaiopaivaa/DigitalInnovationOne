import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory() {
    }

    public static Connection getConnection(){
        String urlConnection = "jdbc:mysql://localhost/digital_innovation_one";
        Connection con = null;
        try {
            con = DriverManager.getConnection(urlConnection,
                    "root","");
            System.out.println("SUCESSO");
        }catch(Exception e){
            System.out.println("FALHA");
        }
        return con;
    }
}
