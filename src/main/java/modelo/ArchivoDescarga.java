/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import excepciones.TiempoExcedidoException;

/**
 *
 * @author dell
 */
public class ArchivoDescarga {
    private String nombreArchivo;
    private int tiempoLimite;

    public ArchivoDescarga(String nombreArchivo, int tiempoLimite) {
        this.nombreArchivo = nombreArchivo;
        this.tiempoLimite = tiempoLimite;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }
    public int getTiempoLimite() {
        return tiempoLimite;
    }
    public void descargar(int tiempo) throws TiempoExcedidoException {
        if (tiempo > tiempoLimite) {
            throw new TiempoExcedidoException("El tiempo de descarga excedio el limite permitido." );
        }
    }

    public void iniciarDescarga(ProcesoListener listener, int tiempo) {
        Runnable proceso = new Runnable() {

            @Override
            public void run() {
                listener.onInicio();
                try {
                    Thread.sleep(tiempo * 1000);
                    descargar(tiempo);
                    listener.onExito();
                }catch (TiempoExcedidoException e) {
                    listener.onError(e.getMessage());

                } catch (InterruptedException e) {
                    listener.onError( "El proceso de descarga fue interrumpido.");
                }
            }
        };
        Thread hilo = new Thread(proceso);
        hilo.start();
    }

    public interface ProcesoListener {
        void onInicio();
        void onExito();
        void onError(String error);
    }
}