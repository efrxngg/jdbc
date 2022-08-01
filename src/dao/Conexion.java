package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexion {
    private Connection cone=null;

    public Connection conectar(String base){
        try{
            Properties dtSesason= new Properties();
            dtSesason.put("user", "root");
            dtSesason.put("password", "root1234");
            String URL=String.format("jdbc:mysql://localhost:3307/%s", base);
            cone= DriverManager.getConnection(URL, dtSesason);


        }catch (SQLException ex){
            System.out.println("Error: "+ ex);
        }
        return cone;
    }


}


class Conexion2{
    private Connection cone=null;
     private Statement stmt=null;

    public Connection conectar(String base){
        try{
            cone= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/"+base,
                    "root",
                    "root1234"
            );
        }
        catch (Exception ex){
            System.out.println("Error al establecer la conexion");
        }
        return cone;
    }
}


