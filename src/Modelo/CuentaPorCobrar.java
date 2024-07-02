/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author edyne
 */
public class CuentaPorCobrar {

    private int idCuenta;
    private int idCliente;
    private String fechaEmision;
    private String fechaVencimiento;
    private double monto;
    private String estado;

    // Constructor vacío
    public CuentaPorCobrar() {
    }

    public Object[] Registro(int num) {
        Object fila[] = {idCliente, monto, fechaEmision, fechaVencimiento, estado};
        return fila;
    }

    // Constructor con parámetros
    public CuentaPorCobrar(int idCuenta, int idCliente, String fechaEmision, String fechaVencimiento, double monto, String estado) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.estado = estado;
    }

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

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
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
                + ", idCliente=" + idCliente
                + ", fechaEmision=" + fechaEmision
                + ", fechaVencimiento=" + fechaVencimiento
                + ", monto=" + monto
                + ", estado='" + estado + '\''
                + '}';
    }
}
