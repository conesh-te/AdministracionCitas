/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tecmilenio.administracioncitas;
import java.io.File;
import java.io.FileWriter; 
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author conesh
 */
public class AdministracionCitas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        ArrayList<Administrador> listaadministradores = new ArrayList<>();
        ArrayList<Doctor> listadoctores = new ArrayList<>();
        ArrayList<Paciente> listapacientes = new ArrayList<>();
        ArrayList<Cita> listacitas = new ArrayList<>();
        
        File carpetadb = new File("db");
        File archivoadmins = new File("db/administradores.csv");
        File archivodoctores = new File("db/doctores.csv");
        File archivopacientes = new File("db/pacientes.csv");
        File archivocitas = new File("db/citas.csv");
        
        try {
            if (!carpetadb.exists()) {
                carpetadb.mkdir();
            }
            
            if (!archivoadmins.exists()) {
                System.out.println("### CONFIGURACIÓN INICIAL DEL SISTEMA ###");
                System.out.println("No se detectaron administradores registrados.");
                System.out.println("Por favor, cree la cuenta del Administrador Principal.\n");
                
                System.out.print("Ingrese el nombre de Usuario: ");
                String nuevousuario = teclado.nextLine();
                
                System.out.print("Ingrese la Contraseña: ");
                String nuevacontrasena = teclado.nextLine();
                
                Administrador primeradmin = new Administrador(nuevousuario, nuevacontrasena);
                listaadministradores.add(primeradmin);
                
                PrintWriter escritor = new PrintWriter(archivoadmins);
                escritor.println(primeradmin.toCSV());
                escritor.close();
                
                System.out.println("\n El Administrador se ha registrado con éxito en 'db/administradores.csv'");
                System.out.println("Reinicie el programa para iniciar sesión.\n");
                return; 
                
            } else {
                Scanner lectorarchivo = new Scanner(archivoadmins);
                while (lectorarchivo.hasNextLine()) {
                    String linea = lectorarchivo.nextLine();
                    String[] datos = linea.split(","); 
                    if (datos.length == 2) {
                        listaadministradores.add(new Administrador(datos[0], datos[1], true));
                    }
                }
                lectorarchivo.close();
            }
            
            if (archivodoctores.exists()) {
                Scanner lector = new Scanner(archivodoctores);
                while (lector.hasNextLine()) {
                    String[] datos = lector.nextLine().split(",");
                    if (datos.length == 3) {
                        listadoctores.add(new Doctor(datos[0], datos[1], datos[2]));
                    }
                }
                lector.close();
            }
            
            if (archivopacientes.exists()) {
                Scanner lector = new Scanner(archivopacientes);
                while (lector.hasNextLine()) {
                    String[] datos = lector.nextLine().split(",");
                    if (datos.length == 2) {
                        listapacientes.add(new Paciente(datos[0], datos[1]));
                    }
                }
                lector.close();
            }
            
            if (archivocitas.exists()) {
                Scanner lector = new Scanner(archivocitas);
                while (lector.hasNextLine()) {
                    String[] datos = lector.nextLine().split(",");
                    if (datos.length == 5) {
                        listacitas.add(new Cita(datos[0], datos[1], datos[2], datos[3], datos[4]));
                    }
                }
                lector.close();
            }
            
        } catch (Exception e) {
            System.out.println("[ERROR] Error al inicializar archivos: " + e.getMessage());
        }
        
        boolean accesoautorizado = false;
        System.out.println("### SISTEMA DE ADMINISTRACIÓN DE CITAS ###");
        System.out.println("Por favor, inicie sesión para continuar.\n");
        
        while (!accesoautorizado) {
            try {
                System.out.print("Usuario: ");
                String usuarioingresado = teclado.nextLine();
                
                System.out.print("Contraseña: ");
                String contrasenaingresada = teclado.nextLine();
                
                String contrasenacodificada = Base64.getEncoder().encodeToString(contrasenaingresada.getBytes());
                
                boolean datoscorrectos = false;
                for (Administrador administrador : listaadministradores) {
                    if (administrador.getusuario().equals(usuarioingresado) && 
                        administrador.getcontrasena().equals(contrasenacodificada)) {
                        datoscorrectos = true;
                        break;
                    }
                }
                
                if (datoscorrectos) {
                    System.out.println("\n Acceso Autorizado. Bienvenido al sistema.");
                    accesoautorizado = true;
                } else {
                    System.out.println("\n[ERROR] Usuario o contraseña incorrectos. Intente de nuevo.\n");
                }
                
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado en el Login: " + e.getMessage());
            }
        }
        
        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("\n### MENÚ PRINCIPAL ###");
                System.out.println("1. Registrar Doctor");
                System.out.println("2. Registrar Paciente");
                System.out.println("3. Agendar Cita");
                System.out.println("4. Mostrar Citas");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                String opcion = teclado.nextLine();
                
                switch (opcion) {
                    case "1":
                        System.out.println("\n### Registrar un nuevo doctor ###");
                        System.out.print("ID del Doctor: ");
                        String iddoc = teclado.nextLine();
                        System.out.print("Nombre Completo: ");
                        String nomdoc = teclado.nextLine();
                        System.out.print("Especialidad: ");
                        String espdoc = teclado.nextLine();
                        
                        Doctor nuevoDoc = new Doctor(iddoc, nomdoc, espdoc);
                        listadoctores.add(nuevoDoc);
                        
                        PrintWriter escDoc = new PrintWriter(new FileWriter(archivodoctores, true));
                        escDoc.println(nuevoDoc.toCSV());
                        escDoc.close();
                        System.out.println("El Doctor fue registrado correctamente");
                        break;
                        
                    case "2":
                        System.out.println("\n### Registrar un nuevo paciente ###");
                        System.out.print("ID del Paciente: ");
                        String idpac = teclado.nextLine();
                        System.out.print("Nombre Completo: ");
                        String nompac = teclado.nextLine();
                        
                        Paciente nuevoPac = new Paciente(idpac, nompac);
                        listapacientes.add(nuevoPac);
                        
                        PrintWriter escPac = new PrintWriter(new FileWriter(archivopacientes, true));
                        escPac.println(nuevoPac.toCSV());
                        escPac.close();
                        System.out.println("El Paciente fue registrado correctamente");
                        break;
                        
                    case "3":
                        System.out.println("\n### Agendar una nueva cita ###");
                        System.out.print("ID de la Cita: ");
                        String idcita = teclado.nextLine();
                        System.out.print("Fecha y Hora (formato 25/09/2026 16:00): ");
                        String fechahora = teclado.nextLine();
                        System.out.print("Motivo de la cita: ");
                        String motivo = teclado.nextLine();
                        System.out.print("ID del Doctor: ");
                        String iddoccita = teclado.nextLine();
                        System.out.print("ID del Paciente: ");
                        String idpaccita = teclado.nextLine();
                        
                        boolean docExiste = false, pacExiste = false;
                        for(Doctor d : listadoctores) if(d.getid().equals(iddoccita)) docExiste = true;
                        for(Paciente p : listapacientes) if(p.getid().equals(idpaccita)) pacExiste = true;
                        
                        if (docExiste && pacExiste) {
                            Cita nuevaCita = new Cita(idcita, fechahora, motivo, iddoccita, idpaccita);
                            listacitas.add(nuevaCita);
                            
                            PrintWriter escCita = new PrintWriter(new FileWriter(archivocitas, true));
                            escCita.println(nuevaCita.toCSV());
                            escCita.close();
                            System.out.println("### Cita registrada correctamente ###");
                        } else {
                            System.out.println("\n[ERROR] No se pudo registrar la cita. Verifique que el ID del doctor y del paciente existan o sean correctos.");
                        }
                        break;
                        
                    case "4":
                        System.out.println("\n### Citas registradas ###");
                        if (listacitas.isEmpty()) {
                            System.out.println("No hay citas registradas.");
                        } else {
                            for (Cita c : listacitas) {
                                String nDoc = c.getiddoctor();
                                String nPac = c.getidpaciente();
                                for(Doctor d : listadoctores) if(d.getid().equals(c.getiddoctor())) nDoc = d.getnombre();
                                for(Paciente p : listapacientes) if(p.getid().equals(c.getidpaciente())) nPac = p.getnombre();
                                
                                System.out.println("Cita [" + c.getidcita() + "] - Fecha: " + c.getfechahora() + 
                                                   " | Doc: " + nDoc + " | Paciente: " + nPac + " | Motivo: " + c.getmotivo());
                            }
                        }
                        break;
                        
                    case "5":
                        System.out.println("\nSaliendo del sistema...");
                        salir = true;
                        break;
                        
                    default:
                        System.out.println("\n[ERROR] Opción no válida, intente de nuevo.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\n[ERROR DEL SISTEMA] Ocurrió un error: " + e.getMessage());
            }
        }
    }
}