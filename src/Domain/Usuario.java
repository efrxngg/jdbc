package Domain;


import java.sql.Date;

public class Usuario extends Persona{
    private String user;
    private String password;
    private String correo;
    private Date fechaRegistro;
    public Usuario(String cedula, String nombre, String apellido, String user, String password, String correo,Date fechaIngreso) {
        super(cedula, nombre, apellido);
        
        this.user=user;
        this.password=password;
        this.correo=correo;
        this.fechaRegistro= fechaIngreso;


    }

    //#region User SET/GET
    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return this.user;
    }
    //#endregion

    //#region Password SET/GET
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    //#endregion

    //#region Correo SET/GET
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public String getCorreo(){
        return this.correo;
    }
    //#endregion

    //#region Fecha SET/GET
    public void setFechaRegistro(int ano, int mes, int dia){
        this.fechaRegistro=new Date(ano-1900, mes-1, dia);
    }
    public Date getFechaRegistro(){
        return this.fechaRegistro;
    }
    //#endregion

    @Override
    public String getData() {
        return 
                getCedula()+" "+
                getNombre()+" "+ 
                getApellido()+" "+
                getUser()+" "+
                getPassword()+" "+
                getCorreo()+" "+
                getFechaRegistro();
    }
    
    

}
