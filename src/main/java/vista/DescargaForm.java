/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author dell
 */
public class DescargaForm{

    public void mostrarInicio(String nombreArchivo) {
        System.out.println("Iniciando descarga de: " + nombreArchivo);
    }

    public void mostrarExito(String nombreArchivo){
        System.out.println(
                "La descarga de " + nombreArchivo
                + " finalizo correctamente."
        );
    }

    public void mostrarError(String mensaje){
        System.out.println("ERROR: " + mensaje);
    }
}