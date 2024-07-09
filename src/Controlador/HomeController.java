/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Vista.*;
import Vista.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author edyne
 */
public class HomeController implements ActionListener {
    
    private final HomeView homeView;
    private Usuario usuario;
    
    public HomeController(HomeView _homeView, Usuario _usuario) {
        this.homeView = _homeView;
        this.usuario = _usuario;
        homeView.setLocationRelativeTo(homeView);
        homeView.setVisible(true);
        homeView.btnClientes.addActionListener(this);
        homeView.btnCuentasPorCobrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == homeView.btnCuentasPorCobrar) {
            var addClient = new FrmRegistroPagos();
            var contro = new CuentasPorCobrarControlador(addClient);
            
            homeView.jDesktopPane1.add(addClient);
        }
        
        if (e.getSource() == homeView.btnClientes) {
            var addClient = new FrmClientes();
            addClient.setVisible(true);
            homeView.jDesktopPane1.add(addClient);
        }
    }
    
}
