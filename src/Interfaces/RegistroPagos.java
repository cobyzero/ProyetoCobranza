/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.RegistroPago;
import java.util.ArrayList;
public interface RegistroPagos {

    public void AgregarRegistroPago(RegistroPago registro);

    public void ActualizarRegistroPago(RegistroPago registro);

    RegistroPago BuscarRegistroPago(int idRegistro);

    public void EliminarRegistroPago(int idRegistro);

    ArrayList<RegistroPago> ListarRegistrosPago();
}
    

