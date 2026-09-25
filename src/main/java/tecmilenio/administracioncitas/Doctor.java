/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecmilenio.administracioncitas;
/**
 *
 * @author conesh
 */
public class Doctor {
    private String id;
    private String nombre;
    private String especialidad;

    public Doctor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getid() { 
        return id; 
    }
    
    public String getnombre() { 
        return nombre; 
    }
    public String getespecialidad() { 
        return especialidad; 
    }
    public String toCSV() {
        return id + "," + nombre + "," + especialidad;
    }
}