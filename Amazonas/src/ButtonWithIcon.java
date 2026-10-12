
import javax.swing.*;

import java.awt.event.MouseEvent;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class ButtonWithIcon extends JButton {

    public ButtonWithIcon(String title, String fileRoute) {
        super(title);
        configButton();
        // Carga y configuración del ícono
        loadImg(fileRoute);
        // Posicionamiento del texto debajo del ícono
        configText();
    }

    public void configButton() {
        Color btnColor = new Color(70, 130, 20);
        this.setBackground(btnColor);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));
        this.setFocusPainted(false);
        this.setBorder(BorderFactory.createLineBorder(btnColor, 8));
        this.setPreferredSize(new Dimension(140, 180));
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
