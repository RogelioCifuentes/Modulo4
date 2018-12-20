package cl.forge.programatufuruto.dao;

import cl.forge.programatufuruto.conexion.Conexion;
import cl.forge.programatufuruto.model.CuentaBancaria;
import cl.forge.programatufuruto.model.Transaccion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransaccionDAO {

    Conexion conexion = new Conexion(); //Si se borra el = new Conexion() tira nullPointerException
    private Statement statement;
    private PreparedStatement psInsertar;

    public void insertarTransaccion(Transaccion o) {

        try {
            statement = conexion.getConexion().createStatement();
            psInsertar = conexion.getConexion().prepareStatement("INSERT INTO transaccion(idTransaccion, tipoTransaccion, monto, idCuenta)" + "VALUES(?,?,?,?)");

            psInsertar.setInt(1, o.getIdTransaccion());
            psInsertar.setString(2, o.getTipoTransaccion());
            psInsertar.setInt(3, o.getMonto());
            psInsertar.setString(4, o.getIdCuenta());
            psInsertar.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar datos." + e);
        }
    }

    public void transaccionesPorId(CuentaBancaria o) {

        try {
            statement = conexion.getConexion().createStatement();
            String query = "SELECT DISTINCT transaccion.* FROM transaccion,cuentabancaria WHERE transaccion.idCuenta = ?";
            PreparedStatement statement = conexion.getConexion().prepareStatement(query);
            statement.setString(1, o.getIdCuenta());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString("idTransaccion"));
                System.out.print(rs.getString("tipoTransaccion"));
                System.out.print(rs.getInt("monto"));
                System.out.print(rs.getString("idCuenta"));
                System.out.println("");
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tipoTransaccion(String tipo) {
        try {
            statement = conexion.getConexion().createStatement();
            String query = "SELECT * FROM transaccion WHERE tipoTransaccion = ?";
            PreparedStatement statement = conexion.getConexion().prepareStatement(query);
            statement.setString(1, tipo);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getInt("idTransaccion"));
                System.out.print(rs.getString("tipoTransaccion"));
                System.out.print(rs.getInt("monto"));
                System.out.print(rs.getString("idCuenta"));
                System.out.println("");
            }

            statement.close();
            rs.close();

        } catch (SQLException o) {
            o.printStackTrace();
        }
    }

    /*public void retirarDinero(String cuenta, int retiroDinero) {

        try {
            statement = conexion.getConexion().createStatement();
            String query = "SELECT saldoDisponible  FROM cuentabancaria, transaccion WHERE cuentaBancaria.idCuenta = ? AND cuentabancaria.idCuenta = transaccion.idCuenta";
            PreparedStatement statement = conexion.getConexion().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            statement.setInt(1, (????????????- retiroDinero));
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    */
}
