package conexion_db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    String url = "jdbc:mysql://localhost:3306/universidad";
    String user = "root";
    String pass = "";

    public void connect() {

        System.out.println("Conectando…");
        try (Connection connection = (Connection) DriverManager.getConnection(url, user, pass)) {
            System.out.println("Conectado!!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
