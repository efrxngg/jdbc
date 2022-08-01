package Introduccion;
import Domain.Usuario;

import java.sql.*;

import java.util.ArrayList;
public class Conexion{
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;

    public ArrayList<Usuario> lista= new ArrayList<Usuario>();

    public Conexion(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3307/dataxie?"+"user=root&password=root1234");
            System.out.println("Conexion establecida");
//            Creacion de la instancia Statement    ---
            stmt=con.createStatement();

//            EJECUCION DE QUERYS   ---
//            Opcion 1 ---  Ejecutar querys
            rs=stmt.executeQuery("select * from usuario");
//            Opcion 2 --- Retornara true si el query es un select y falso si fue update, insert, delete
            if(stmt.execute("select * from usuario")){
               rs=stmt.getResultSet();
            }

            while(rs.next()){
//                lista.add(rs.getString("id_usuario")); //Se utiliza el metodo getTipoDato para obtener la informacion del query
//                lista.add(new Usuario(rs.getString(1), rs.getString(2)));

            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex);
        }
        finally {
//            LIBERACION DE RECURSOS
            if (rs!=null){
                try{
                    rs.close();
                } catch (SQLException e) {}
                rs=null;
            }

            if (stmt!=null){
                try{
                    stmt.close();
                }catch(SQLException e){}
                stmt=null;
            }
            }
        }



        public static void main(String[] args) {
            var objC=new Conexion();
            for(Usuario i: objC.lista){
                System.out.println(i.getData());
            }
        }
    }



/**Notas
 * Connection -> Sirve para establecer la conexion a la base de datos
 * Statement -> Sirve para ejecutar consultas query SQL basicas y recuperar los resultados a traves de ResultSet
 * ResultSet -> Sirve para almacenar el resultado del query
 * getStrin(ColumnLabel/indexLabel) -> Sirve para obtener el resulado de la consulta
 * executeQuery -> Sirve para ejecutar querys basicos y se almacena directamente en un objeto de tipo rs
 * execute ->Sirve para ejecutar querys basicos y retorna true si es de tipo select y false si es de otro
 * executeUpdate -> Sirve para ejecutar la declaracion sql en tipo DML como insert, update, delete o una declaracion que no devuelva nada como una declaracion ddl
 */




