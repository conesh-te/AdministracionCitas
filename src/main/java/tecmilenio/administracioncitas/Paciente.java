/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecmilenio.administracioncitas;
/**
 *
 * @author conesh
 */
public class Paciente {
    private String id;
    private String nombre;

    public Paciente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getid() { 
        return id; 
    }
    
    public String getnombre() { 
        return nombre; 
    }

    public String toCSV() {
        return id + "," + nombre;
    }
}