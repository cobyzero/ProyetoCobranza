/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Usuario;
import Vistas.AgregarClienteFrame;
import Vistas.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author edyne
 */
public class HomeController implements ActionListener {
    private final HomeView homeView;
    private Usuario usuario;
    
    public HomeController(HomeView _homeView, Usuario _usuario){
        this.homeView = _homeView;
        this.usuario = _usuario;
        homeView.setLocationRelativeTo(homeView);
        homeView.setVisible(true);
        homeView.btnAgregarCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource() == homeView.btnAgregarCliente){
           var addClient = new AgregarClienteFrame();
           
           homeView.jDesktopPane1.add(addClient);
           addClient.setVisible(true);
       }
    }
    
    
}
