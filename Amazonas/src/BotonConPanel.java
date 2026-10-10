
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class BotonConPanel extends JFrame {

    public BotonConPanel() {
        setTitle("Ejemplo de Botón con Panel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // 1. Crear el JButton principal con un Layout
        JButton botonTarjeta = new JButton();
        botonTarjeta.setLayout(new BorderLayout());
        botonTarjeta.setPreferredSize(new Dimension(280, 120));
        // Un margen interno para que el panel no toque los bordes del botón
        botonTarjeta.setMargin(new Insets(10, 10, 10, 10)); 

        // 2. Crear el JPanel interno
        // Usamos GridLayout para organizar sub-elementos verticalmente
        JPanel panelInterno = new JPanel(new GridLayout(2, 1, 5, 5));
        panelInterno.setOpaque(false); // Hace que el panel sea transparente y se vea el fondo del botón

        // 3. Crear y agregar los componentes al panel
        JLabel titulo = new JLabel("Producto Premium", SwingConstants.LEFT);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel descripcion = new JLabel("<html>Precio: $49.99<br>Disponible en tienda</html>", SwingConstants.LEFT);
        descripcion.setFont(new Font("Arial", Font.PLAIN, 12));

        panelInterno.add(titulo);
        panelInterno.add(descripcion);

        // 4. Meter el JPanel DENTRO del JButton
        botonTarjeta.add(panelInterno, BorderLayout.CENTER);

        // Acción al presionar el botón
        botonTarjeta.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Seleccionaste el producto.");
        });

        add(botonTarjeta);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BotonConPanel().setVisible(true);
        });
    }
}


