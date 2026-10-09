package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FormFrame extends JFrame {
    private MainPanel panel;
    public  FormFrame (){
        super("Formulario de pago");
        panel = new MainPanel();
        this.setLayout(new GridLayout());
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(400,300);
        this.setVisible(true);
    }

}
