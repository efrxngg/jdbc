package dao;

import Domain.Usuario;
import interfaces.CrudUsuario;
import java.sql.*;
import java.util.ArrayList;

public class CrudUsuarioBD implements CrudUsuario {

    private Conexion con=new Conexion();
    private Statement stmt=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;

    @Override
    public ArrayList<Usuario> getAll(String base) {
        ArrayList<Usuario>listaUsuarios=new ArrayList<Usuario>();
        var cone=con.conectar(base);
        try{
            stmt=cone.createStatement();
            if(stmt.execute("select * from usuario")){
                rs=stmt.getResultSet();
            }
            while(rs.next()){
                listaUsuarios.add(new Usuario(
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("user"),
                        rs.getString("password"),
                        rs.getString("correo"),
                        rs.getDate("fecha_registro")
                ));
            }
        }
        catch (SQLException ex){
            System.out.println("Error: "+ ex);
        }
        finally {
            releaseSource(rs, stmt, cone);
        }

        return listaUsuarios;
    }

    @Override
    public Usuario getOne(String base, String cedula) {
        Usuario objU=null;
        var cone=con.conectar(base);
        try{
            stmt=cone.createStatement();
            rs=stmt.executeQuery("select * from usuario where cedula="+cedula);
            rs.next();
                objU= new Usuario(
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("user"),
                        rs.getString("password"),
                        rs.getString("correo"),
                        rs.getDate("fecha_registro"));
        }
        catch (SQLException ex){
            System.out.println("Error: "+ex);
        }
        finally {
            releaseSource(rs, stmt, cone);
        }

        return objU;
    }

    @Override
    public String insert(String base, String[] datos) {
        String msg="";
        var cone=con.conectar(base);
        var validador=getOne(base, datos[0]);

        if(validador==null){
            try{
                stmt=cone.createStatement();
                var query=String.format("insert into usuario(cedula, nombre, apellido, user, password, correo) values('%s', '%s', '%s', '%s', '%s', '%s')", datos);
//            System.out.println(sql);
                int rex=stmt.executeUpdate(query);
                msg=rex+" Registro Actualizados";

            }catch(SQLException Exsql){
                System.out.println("Error: "+Exsql);
            }
            finally {
                releaseSource(rs, stmt, cone);
            }
        }else{
            msg="Usuario ya registrado";
        }
        return msg;
    }

    @Override
    public String update(String base, String[] datos) {
        String msg="";
        var cone=con.conectar(base);
        try{
            String query=String.format("update usuario set nombre='%s', apellido='%s', user='%s', password='%s', correo='%s' where cedula='%s'", datos);
            pstmt=cone.prepareStatement(query);

            int rex=pstmt.executeUpdate();
            msg=rex+" Registro Actualizado";
            pstmt.close();
        }
        catch(SQLException ex){
            System.out.println("Error: "+ex);
        }
        finally {
            releaseSource(rs, pstmt, cone);
        }



        return msg;
    }

    @Override
    public String delete(String base, String cedula) {
        String msg="";
        var cone=con.conectar(base);
        try{
            var query=String.format("delete from usuario where cedula='%s'", cedula);
            pstmt= cone.prepareStatement(query);
            msg=pstmt.executeUpdate()+" Registros Afectados";

        }
        catch(SQLException ex){
            System.out.println("Error: "+ex);
        }
        finally {
            releaseSource(rs, pstmt, cone);
        }

        return msg;
    }

    private void releaseSource(ResultSet rs, Statement stmt, Connection cone){
        if (rs!=null){
            try{
                rs.close();
            }
            catch (SQLException sqlEx){rs=null;}
        }
        if (stmt!=null){
            try{
                stmt.close();
            }
            catch (SQLException sqlEx){stmt=null;}
        }
        try{

            cone.close();
        }
        catch(Exception ex){}
    }

    private void releaseSource(ResultSet rs, PreparedStatement pstmt, Connection cone){
        if (rs!=null){
            try{
                rs.close();
            }
            catch (SQLException sqlEx){rs=null;}
        }
        if (stmt!=null){
            try{
                pstmt.close();
            }
            catch (SQLException sqlEx){stmt=null;}
        }
        try{

            cone.close();
        }
        catch(Exception ex){}
    }

}
