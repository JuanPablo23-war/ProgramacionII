package co.edu.uptc.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JButton {
    public JButton() {
        super("botones");
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        JButton button1 = new JButton("Aceptar");
        JButton button2 = new JButton("Cancelar");
        container.add(button1);
        container.add(button2);
        this.setSize(350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
