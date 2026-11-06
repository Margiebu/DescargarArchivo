/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.ArchivoDescarga;
import vista.DescargaForm;

/**
 *
 * @author dell
 */
public class DescargaController {

    private DescargaForm vista;
    public DescargaController(){
        vista = new DescargaForm();
    }
    public void iniciarDescarga(){
        String nombreArchivo = "documento.pdf";
        int tiempoDescarga = 5;
        int tiempoLimite = 10;

        ArchivoDescarga archivo =new ArchivoDescarga(nombreArchivo, tiempoLimite);
        ArchivoDescarga.ProcesoListener listener = new ArchivoDescarga.ProcesoListener(){

            @Override
            public void onInicio(){
                vista.mostrarInicio(nombreArchivo);
            }

            @Override
            public void onExito(){
                vista.mostrarExito(nombreArchivo);
            }
            @Override
            public void onError(String error){
                vista.mostrarError(error);
            }
        };
        archivo.iniciarDescarga(listener, tiempoDescarga);
    }

    public static void main(String[] args) {
        DescargaController controller =new DescargaController();
        controller.iniciarDescarga();
    }
}