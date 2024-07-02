/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.CuentaPorCobrar;
import java.util.ArrayList;

/**
 *
 * @author edyne
 */
public interface InterfaceCuentasPorCobrar {

    public void AgregarCuentaPorCobrar(CuentaPorCobrar cat);

    public void ActualizarCuentaPorCobrar(CuentaPorCobrar cat);

    public CuentaPorCobrar BuscarCuentaPorCobrar(int idcat);

    public void EliminarCuentaPorCobrar(int idcat);

    public ArrayList<CuentaPorCobrar> ListarCuentaPorCobrar();
    
    public boolean ExisteClienteConCuentaDeCobro(int idCliente);
}
