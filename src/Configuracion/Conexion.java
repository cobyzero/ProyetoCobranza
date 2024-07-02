package Configuracion;
//libreria
import java.sql.*;
import Procesos.Mensajes;
public class Conexion implements Parametros {
 
 public static Connection HacerConexion(){
     Connection con=null;
     try{
         Class.forName(DRIVER);
         con = DriverManager.getConnection(URL,USER,CLAVE);         
     }catch(Exception ex){
         Mensajes.MostrarTexto("ERROR no se puede conectar a la BD "+ex);
     }
     return con;
 }       
    
}//fin de la clase.
