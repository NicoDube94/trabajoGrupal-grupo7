/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernan57
 */
public class conexion {
    public String db = "universidad";
    public String url = "jdbc:mysql://localhost:3306/"+db;
    public String user = "root";
    public String pass = "";


   public Connection Conectar(){

       Connection link = null;

       try{

           Class.forName("com.mysql.jdbc.Driver");

           link = DriverManager.getConnection(this.url, this.user, this.pass);

       }catch(Exception ex){

           JOptionPane.showMessageDialog(null,"Error al conectarse"+ ex);

       }

       return link;

   }
    /*public Connection getConnection()
    {
        if(con==null)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection)DriverManager.getConnection(url, user, pass);
            }
            catch (SQLException |ClassNotFoundException e)
            {
                System.err.print(e);
            }
        }
                return con;
    }
}

 */
}
