/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

 import Controladores.LoginController;
import Vista.Login;
 
/**
 *
 * @author edyne
 */
public class Principal {
    public static void main(String[] args) {
        LoginController loginController = new LoginController(new Login());
    }
}
