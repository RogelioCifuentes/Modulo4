package cl.forge.programatufuruto.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaccion {

    private int idTransaccion;
    private String tipoTransaccion;
    private int monto;
    private String idCuenta;


    public Transaccion() {
        this.idTransaccion = 0;
        this.tipoTransaccion = "";
        this.monto = 0;
        this.idCuenta = "";
    }

    public Transaccion(int idTransaccion, String tipoTransaccion, int monto, String idCuenta) {
        this.idTransaccion = idTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.idCuenta = idCuenta;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

}
