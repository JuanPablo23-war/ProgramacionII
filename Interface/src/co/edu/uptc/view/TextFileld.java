package co.edu.uptc.view;

import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TextFileld  extends JFrame {
    public TextFileld() {
        super("ventana de texto");
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        JTextField textField = new JTextField(10);
        container.add(new JLabel("Nombre: "));
        container.add(textField);
        this.setSize(350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
