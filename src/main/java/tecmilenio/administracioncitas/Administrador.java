/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecmilenio.administracioncitas;
import java.util.Base64;
/**
 *
 * @author conesh
 */
public class Administrador {
    private String usuario;
    private String contrasena;

    public Administrador(String usuario, String contrasenasinproteger) {
        this.usuario = usuario;
        this.contrasena = Base64.getEncoder().encodeToString(contrasenasinproteger.getBytes());
    }
    
    public Administrador(String usuario, String contrasenacodificada, boolean esCifrada) {
        this.usuario = usuario;
        this.contrasena = contrasenacodificada; 
    }
    
    public String getusuario() { 
        return usuario; 
    }
    
    public String getcontrasena() { 
        return contrasena; 
    }
    
    public String toCSV() {
        return usuario + "," + contrasena;
    }
} 
