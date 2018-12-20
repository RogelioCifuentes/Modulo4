package cl.forge.programatufuruto.dao;

import cl.forge.programatufuruto.conexion.Conexion;
import cl.forge.programatufuruto.model.CuentaBancaria;

import java.sql.*;

public class CuentaBancariaDAO {

    private PreparedStatement psInsertar;
    private Statement statement;
    Conexion conexion;

    public void insertarCuentaBancaria(CuentaBancaria o) {

        try {
            statement = conexion.getConexion().createStatement();
            psInsertar = conexion.getConexion().prepareStatement("INSERT INTO cuentabancaria(idCuenta, saldoDisponible, tipoCuenta)" + "VALUES(?,?,?)");

            psInsertar.setString(1, o.getIdCuenta());
            psInsertar.setInt(2, o.getSaldoDisponible());
            psInsertar.setString(3, o.getTipoCuenta());
            psInsertar.executeUpdate();

            statement.close();
            psInsertar.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar datos." + e);
        }
    }

    public void llamarCuentas(){

        try {
            statement = conexion.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select * from cuentabancaria");

            while(rs.next()){

                System.out.print(rs.getString("idCuenta"));
                System.out.print(rs.getInt("saldoDisponible"));
                System.out.print(rs.getString("tipoCuenta"));
                System.out.println("");
            }
            statement.close();
            rs.close();
        }catch(SQLException e){
            System.out.println("Error al llamar datos."+ e);
        }
        }
}
