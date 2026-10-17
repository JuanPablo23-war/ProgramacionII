import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ScrollHorizontal extends JPanel {
    private JLabel labelImage;
    private JButton right, left;
    private ArrayList<String> routes;
    private int position = 0;

    public ScrollHorizontal(ArrayList<String> routes) {
        this.routes = routes;
        initComponets();
    }

    public void initComponets() {
        createComponets();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(left, gbc);
        addActionListenerLeft();
        gbc.weightx = 0.8;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.BOTH;
        add(labelImage, gbc);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(right, gbc);
        addActionListenerRight();
    }

    public void createComponets() {
        labelImage = new JLabel();
        getImage(routes.get(0));
        right = new JButton(">>");
        left = new JButton("<<");
    }

    public void addActionListenerRight() {
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (position < routes.size() - 1 && routes != null) {
                    position += 1;
                    getImage(routes.get(position));
                }
            }
        });
    }

    public void addActionListenerLeft() {
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (position > 0 && routes != null) {
                    position -= 1;
                    getImage(routes.get(position));
                }
            }
        });
    }

    public void getImage(String filePath) {
        try {
            ImageIcon iconOriginal = new ImageIcon(filePath);
            Image imageRelazed = iconOriginal.getImage().getScaledInstance(1360,342, Image.SCALE_SMOOTH);
            labelImage.setIcon(new ImageIcon(imageRelazed));
        } catch (Exception e) {
            labelImage.setText("[Imagen]");
        }
    }
}
