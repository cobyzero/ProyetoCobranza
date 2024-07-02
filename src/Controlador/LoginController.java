/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import AccesoDatos.DAO_Usuarios;
import Vista.Login;
import Vista.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 *
 * @author edyne
 */
public class LoginController extends DAO_Usuarios implements ActionListener {

    private final Login login;

    public LoginController(Login login) {
        this.login = login;

        this.login.setLocationRelativeTo(login);
        this.login.setVisible(true);
        login.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login.btnLogin) {
            var user = Login(login.userTxt1.getText(), login.passTxt.getText());

            if (user != null) {
                login.setVisible(false);
                HomeController homeController = new HomeController(new HomeView(), user);
            }

        }

    }
}
