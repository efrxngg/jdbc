package interfaces;


import Domain.Usuario;
import java.util.ArrayList;

public interface CrudUsuario {
    ArrayList<Usuario> getAll(String base);
    Usuario getOne(String base, String cedula);
    String insert(String base, String[] datos);
    String update(String base, String[] datos);
    String delete(String base, String cedula);

}
