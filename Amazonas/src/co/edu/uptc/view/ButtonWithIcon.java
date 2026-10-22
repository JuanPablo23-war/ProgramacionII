package co.edu.uptc.view;

import javax.swing.*;

import java.awt.event.MouseEvent;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class ButtonWithIcon extends JButton {
    private Color btnColor;

    public ButtonWithIcon(String title, String fileRoute, Color btnColor) {
        super(title);
        this.btnColor = btnColor;
        configButton();
        // Carga y configuración del ícono
        loadImg(fileRoute);
        // Posicionamiento del texto debajo del ícono
        configText();
    }

    public void configButton() {
        this.setBackground(btnColor);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Nunito Sans", Font.BOLD, 16));
        this.setFocusPainted(false);
        this.setBorder(BorderFactory.createLineBorder(btnColor, 8));
        Dimension buttonSize = new Dimension(140, 180);
        this.setPreferredSize(buttonSize);
        this.setMinimumSize(buttonSize);
        this.setMaximumSize(buttonSize);
        addMauseEvent(btnColor);
    }

    public void loadImg(String fileRoute) {
        try {
            ImageIcon icon = new ImageIcon(fileRoute);
            Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no se pudo cargar la imagen");
        }
    }

    public void configText() {
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setIconTextGap(15);
    }

    public void addMauseEvent(Color btnColor){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.WHITE);
                setForeground(btnColor);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(btnColor);
                setForeground(Color.WHITE);
            }
        });
    }

}
