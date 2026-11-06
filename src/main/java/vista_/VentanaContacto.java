/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista_;
import javax.swing.*;
import java.awt.*;
import modelo_.Contacto;
/**
 *
 * @author dell
 */
import javax.swing.*;
import java.awt.*;
import modelo_.Contacto;

public class VentanaContacto extends JFrame {

    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JButton btnProcesar;
    private JLabel lblResultado;

    public VentanaContacto() {

        setTitle("Registro de Contacto");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 2, 5, 5));

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();

        JLabel lblTelefono = new JLabel("Telefono:");
        txtTelefono = new JTextField();

        btnProcesar = new JButton("Procesar");
        lblResultado = new JLabel("Resultado: ");

        add(lblNombre);
        add(txtNombre);

        add(lblTelefono);
        add(txtTelefono);

        add(btnProcesar);
        add(new JLabel(""));

        add(lblResultado);
        add(new JLabel(""));

        btnProcesar.addActionListener(
            new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(
                    java.awt.event.ActionEvent evt) {

                    btnProcesarActionPerformed(evt);
                }
            }
        );
    }

    private void btnProcesarActionPerformed(
            java.awt.event.ActionEvent evt) {

        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();

        Contacto contacto = new Contacto(nombre, telefono);

        lblResultado.setText(
            "Nombre: " + contacto.getNombre()
            + " | Telefono: " + contacto.getTelefono()
        );
    }
}