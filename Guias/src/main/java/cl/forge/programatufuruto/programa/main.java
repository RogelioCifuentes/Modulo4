package cl.forge.programatufuruto.programa;

import cl.forge.programatufuruto.conexion.Conexion;
import cl.forge.programatufuruto.dao.TransaccionDAO;
import cl.forge.programatufuruto.model.CuentaBancaria;
import cl.forge.programatufuruto.model.Transaccion;

import java.sql.SQLException;
import java.sql.Statement;

public class main {


    public static void main(String[] args) throws SQLException {

        Conexion conexion = new Conexion();

 //Creacion de objetos CuentaBancaria
        CuentaBancaria cuenta1 = new CuentaBancaria("1",666,"vista");
        CuentaBancaria cuenta2 = new CuentaBancaria("2",667, "santander");
        CuentaBancaria cuenta3 = new CuentaBancaria("3",111, "bbva azul");
        CuentaBancaria cuenta4 = new CuentaBancaria("4",222, "santander");
        CuentaBancaria cuenta5 = new CuentaBancaria("5",555, "rut");
        CuentaBancaria cuenta6 = new CuentaBancaria("6",333, "credito");

   // Insertar
        //CuentaBancariaDAO cuenta = new CuentaBancariaDAO();   <- Se necesita crear un objeto "CuentaBancariaDAO" ya que es el que tiene el metodo para insertar.
      //  cuenta.insertarCuentaBancaria(cuenta1)                <-- Desde la cuenta1 a la cuenta6

    //Mostrar
     //   cuenta.mostrarCuentas()                               <-- Muestra todas las cuentas de la tabla 'CuentaBancaria'.





//Creando objetos Transaccion

        Transaccion transaccion1 = new Transaccion(101,"abono",10000,"1");
        Transaccion transaccion2 = new Transaccion(102,"deposito",15000,"2");
        Transaccion transaccion3 = new Transaccion(103,"abono",18000,"1");
        Transaccion transaccion4 = new Transaccion(104,"retiro",15000,"2");
        Transaccion transaccion5 = new Transaccion(105,"abono",12000,"1");
        Transaccion transaccion6 = new Transaccion(106,"abono",9999,"2");

        TransaccionDAO transaccion = new TransaccionDAO();

        //Ingresando transacciones.
/*
        transaccion.insertarTransaccion(transaccion1);
        transaccion.insertarTransaccion(transaccion2);
        transaccion.insertarTransaccion(transaccion3);
        transaccion.insertarTransaccion(transaccion4);
        transaccion.insertarTransaccion(transaccion5);
        transaccion.insertarTransaccion(transaccion6);
*/

        transaccion.transaccionesPorId(cuenta1);

        //Sirve para borrar registros.
        /*
        Conexion conexion = new Conexion();
        Statement sentenciaDelete = conexion.getConexion().createStatement();
       */

    conexion.desconectar();

    }
}