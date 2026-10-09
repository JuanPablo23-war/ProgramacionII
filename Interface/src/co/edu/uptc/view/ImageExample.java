package co.edu.uptc.view;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageExample extends JFrame {
    public ImageExample(String path) {
        super("porche");
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        ImageIcon image = new ImageIcon(path);
        Image img = image.getImage();
        Image newimg = img.getScaledInstance(300, 401, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(newimg);
        container.add(new JLabel("", image, JLabel.CENTER));
        this.setSize(650, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
