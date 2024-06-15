/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author edyne
 */
import java.util.Date;

public class CuentaPorCobrar {

    private int idCuenta;
    private int idCliente;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private double monto;
    private String estado;

    // Constructor vacío
    public CuentaPorCobrar() {
    }

    // Constructor con parámetros
    public CuentaPorCobrar(int idCuenta, int idCliente, Date fechaEmision, Date fechaVencimiento, double monto, String estado) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CuentaPorCobrar{"
                + "idCuenta=" + idCuenta
                + ", idCliente=" + idCliente
                + ", fechaEmision=" + fechaEmision
                + ", fechaVencimiento=" + fechaVencimiento
                + ", monto=" + monto
                + ", estado='" + estado + '\''
                + '}';
    }
}
