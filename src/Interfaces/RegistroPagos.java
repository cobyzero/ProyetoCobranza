/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.RegistroPago;
import java.util.ArrayList;
public interface RegistroPagos {

    void AgregarRegistroPago(RegistroPagos registro);

    void ActualizarRegistroPago(RegistroPagos registro);

    RegistroPagos BuscarRegistroPago(int idRegistro);

    void EliminarRegistroPago(int idRegistro);

    ArrayList<RegistroPagos> ListarRegistrosPago();
}
    

