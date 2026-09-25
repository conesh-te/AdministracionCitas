/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecmilenio.administracioncitas;
/**
 *
 * @author conesh
 */
public class Cita {
    
    private String idcita;
    private String fechahora; // Ejemplo: "25/09/2026 15:30"
    private String motivo;
    
    private String iddoctor; 
    private String idpaciente;

        public Cita(String idcita, String fechahora, String motivo, String iddoctor, String idpaciente) {
        this.idcita = idcita;
        this.fechahora = fechahora;
        this.motivo = motivo;
        this.iddoctor = iddoctor;
        this.idpaciente = idpaciente;
    }
    
    public String getidcita() { return idcita; }
    public String getfechahora() { return fechahora; }
    public String getmotivo() { return motivo; }
    public String getiddoctor() { return iddoctor; }
    public String getidpaciente() { return idpaciente; }

    public String toCSV() {
        return idcita + "," + fechahora + "," + motivo + "," + iddoctor + "," + idpaciente;
    }
} 
