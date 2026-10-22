package co.edu.uptc.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchFrame extends JFrame {
    private JPanel searchArea;
    private GridBagConstraints gbc;

    public SearchFrame(String text) {
        super("Gobierno de amazonas");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        HeaderPanel headerPanel = new HeaderPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.cleanSearchField();
        add(headerPanel, BorderLayout.NORTH);
        searchPanel(text);
        add(searchArea);
        setVisible(true);
    }

    public void searchPanel(String text) {
        initLayout();
        createLabelBrowser();
        createLabelTitle();
        createLabelSubtitle();
        createSearchBox(text);

        gbc.gridy = 4;
        gbc.weighty = 1.0;
        searchArea.add(Box.createVerticalGlue(), gbc);
    }

    public void initLayout() {
        searchArea = new JPanel();
        searchArea.setBackground(Color.WHITE);
        searchArea.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
    }

    public void createLabelBrowser() {
        JLabel lblBrowser = new JLabel(
                "<html><font color='#3b82f6'>Inicio</font> <font color='#070785'>&gt;</font> <b><font color='#0f172a'>Buscador</font></b></html>");
        lblBrowser.setFont(new Font("SansSerif", Font.PLAIN, 12));
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 15, 0);
        searchArea.add(lblBrowser, gbc);
    }

    public void createLabelTitle() {
        JLabel lblTitle = new JLabel("Buscador");
        lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 36));
        lblTitle.setForeground(new Color(56, 163, 255)); // Azul claro
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        searchArea.add(lblTitle, gbc);
    }

    public void createLabelSubtitle() {
        JLabel lblSubtitle = new JLabel("¿Qué estas buscando?");
        lblSubtitle.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblSubtitle.setForeground(new Color(56, 163, 255)); // Azul claro
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 10, 0);
        searchArea.add(lblSubtitle, gbc);
    }

    public void createSearchBox(String text) {
        JPanel searchBox = new JPanel(new BorderLayout());
        JTextField searchField = new JTextField(text);
        JButton searchBtn = new JButton("\uD83D\uDD0D");
        searchBtn.setBackground(new Color(0, 51, 102));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
        searchBtn.setFocusPainted(false);
        searchBtn.setBorder(new EmptyBorder(5, 15, 5, 15));
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchBtn.setOpaque(true);
        searchBox.add(searchField, BorderLayout.CENTER);
        searchBox.add(searchBtn, BorderLayout.EAST);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 0, 0);
        searchArea.add(searchBox, gbc);
    }


}
