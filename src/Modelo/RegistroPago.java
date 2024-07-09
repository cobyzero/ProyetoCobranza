/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ismae
 */
public class RegistroPago {
    private int idPago;
    private int idCliente;
    private String fechaPago;
    private String metodoPago;
    private double monto;
    private String estado;

    // Constructor vacío
    public RegistroPago() {
    }

    // Constructor con parámetros
    public RegistroPago(int idPago, int idCliente, String fechaPago, String metodoPago, double monto, String estado) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.estado = estado;
    }

    // Método para obtener una fila de registro para mostrar en una tabla
    public Object[] getRegistro() {
        Object fila[] = {idCliente, monto, fechaPago, metodoPago, estado};
        return fila;
    }

    // Getters y setters

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
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
        return "Pago{" +
                "idPago=" + idPago +
                ", idCliente=" + idCliente +
                ", fechaPago='" + fechaPago + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", monto=" + monto +
                ", estado='" + estado + '\'' +
                '}';
    }
    
}
