/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Controladores.HomeController;
import Vistas.HomeView;

/**
 *
 * @author edyne
 */
public class Principal {
    public static void main(String[] args) {
        HomeController homeController = new HomeController(new HomeView());
    }
}
