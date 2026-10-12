import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseEvent;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class MenuBtn  extends  JButton{

    public MenuBtn(String title, Color btnColor) {
        super(title);
        configButton(btnColor);
        configText();
    }

    public void configButton(Color btnColor) {
       // Color btnColor = new Color(245, 245, 245);
        this.setFont(new Font("SansSerif", Font.PLAIN, 14));
        this.setBackground(btnColor);
        this.setForeground(Color.DARK_GRAY);
        this.setFocusPainted(false);
        this.setBorder(new EmptyBorder(15, 25, 15, 25)); // Padding interno
        this.setContentAreaFilled(true);
        this.setOpaque(true);
        addMauseEvent(btnColor);
    }

    public void configText() {
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    public void addMauseEvent(Color btnColor){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(200,200,200));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(btnColor);
            }
        });
    }
}

