package co.edu.uptc.view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TextArea extends JFrame{
    public TextArea() {
        super("ventana de texto");
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        JTextArea textA = new JTextArea(3, 10);
        container.add(new JLabel("Observación: "));
        container.add(textA);
        this.setSize(350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
