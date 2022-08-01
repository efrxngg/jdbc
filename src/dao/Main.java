package dao;

import Domain.Usuario;

import java.sql.Date;


public class Main {
    public static void main(String[] args) {
//        var con= new Conexion();
//        con.conectar("dataxie");

        CrudUsuarioBD objCU=new CrudUsuarioBD();
//        System.out.println(objCU.delete("empresax", "0954943111"));
//        String[] datos={"Pepe", "Castro", "ENANAGORDA", "1234", "gisell@gmail.com", "0954943118"};
//        System.out.println(objCU.update("empresax", datos));

//        String[] datos={"0954943111", "Gisell", "Castro", "ENANAGORDA", "1234", "gisell@gmail.com"};
//        System.out.println(objCU.insert("empresax", datos));



//        var obj=objCU.getOne("empresax", "0954943114");
//        System.out.println(obj.getData());


        var lista=objCU.getAll("empresax");
        for(Usuario i: lista){
            System.out.println(i.getData());
        }

//        Conexion2 objC2=new Conexion2();
//        objC2.conectar("empresax");

    }
}
