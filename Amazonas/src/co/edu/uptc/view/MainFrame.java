package co.edu.uptc.view;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame {
    private ScrollPanel scrollPanel;
    private HeaderPanel headerPanel;
    private ButtonsPanel buttonPanel;
    private ScrollHorizontal scrollHorizontal;

    public MainFrame() {
        super("Gobierno de amazonas");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        scrollPanel = new ScrollPanel();

        headerPanel = new HeaderPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        scrollHorizontal = new ScrollHorizontal(routes());
        buttonPanel = new ButtonsPanel();

        mapOut();

        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setVerticalScrollBarPolicy(
                scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(
                scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public ArrayList<String> routes() {
        ArrayList<String> images = new ArrayList<>();
        images.add("data/scrollImages/image1.jpg");
        images.add("data/scrollImages/imagen2.jpg");
        images.add("data/scrollImages/121970_121970_5000x1250.png");
        images.add("data/scrollImages/imagen4.jpg");
        images.add("data/scrollImages/imagen5.jpg");
        return images;
    }

    public void mapOut() {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.weighty = 0.0;
        scrollPanel.add(headerPanel, c);

        c.gridy = 1;
        c.weighty = 0.0;
        scrollPanel.add(scrollHorizontal, c);

        c.gridy = 2;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.NONE;
        scrollPanel.add(buttonPanel, c);

    }
}
