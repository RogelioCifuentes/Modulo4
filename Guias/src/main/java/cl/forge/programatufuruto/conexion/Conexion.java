package cl.forge.programatufuruto.conexion;

import cl.forge.programatufuruto.exception.SinConexionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String password = "hola1234";
    private static final String url = "jdbc:mysql://localhost:3306/banco";

    public Conexion(){
        conexion = null;
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,usuario,password);

            if(conexion != null){
                System.out.println("Conexion exitosa.");
            }

        }catch(Exception e){
            System.out.println("Error "+ e);
        }
    }

    //Retorna la conexion
    public Connection getConexion(){
        return conexion;
    }

    //Metodo que desconecta de la DB
    public void desconectar(){
        conexion = null;

        if( conexion == null ){
            System.out.println("Desconectado.");
        }
    }

}

