/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author edyne
 */
import java.util.Date;

public class Pago {

    private int idPago;
    private int idCuenta;
    private Date fechaPago;
    private double montoPagado;
    private String metodoPago;

    // Constructor vacío
    public Pago() {
    }

    // Constructor con parámetros
    public Pago(int idPago, int idCuenta, Date fechaPago, double montoPagado, String metodoPago) {
        this.idPago = idPago;
        this.idCuenta = idCuenta;
        this.fechaPago = fechaPago;
        this.montoPagado = montoPagado;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Pago{"
                + "idPago=" + idPago
                + ", idCuenta=" + idCuenta
                + ", fechaPago=" + fechaPago
                + ", montoPagado=" + montoPagado
                + ", metodoPago='" + metodoPago + '\''
                + '}';
    }

    public String getFecha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
