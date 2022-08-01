package Domain;

import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Persona {
    private String cedula;
    private String nombre;
    private String apellido;
    public Persona(String cedula, String nombre, String apellido){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    //#region Cedula
    public void setCedula(String cedula){
        this.cedula=cedula;
    }

    public String getCedula() {
        return this.cedula;
    }
    //#endregion

    //#region Nombre

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
    //#endregion

    //#region Apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }
    //#endregion
    public abstract String getData();
}
