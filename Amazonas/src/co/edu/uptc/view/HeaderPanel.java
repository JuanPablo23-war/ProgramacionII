package co.edu.uptc.view;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HeaderPanel extends JPanel {
    private JPanel topPanel, centerPanel, menuPanel;
    private JTextField searchField;

    public HeaderPanel() {
        createTopPanel();
        createCenterPanel();
        createMenuPanel();
        add(topPanel);
        add(centerPanel);
        add(menuPanel);
    }

    public void createTopPanel() {
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(new Color(0, 51, 160));
        JLabel govLabel = new JLabel("gov.co");
        govLabel.setForeground(Color.WHITE);
        govLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        topPanel.add(govLabel);
    }

    public JPanel createLeftZone() {
        JPanel titleArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titleArea.setBackground(Color.WHITE);
        JLabel logoLabel = labelLogo();
        JLabel titleLabel = new JLabel(" | Gobernación del Amazonas");
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
        titleLabel.setForeground(new Color(50, 50, 50));
        titleArea.add(logoLabel);
        titleArea.add(titleLabel);
        return titleArea;
    }
    public JLabel labelLogo() {
        ImageIcon logoIcon = new ImageIcon("data/logo/logoGobiernoA.png");
        Image img = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(img);
        JLabel logoLabel = new JLabel(logoIcon);
        return logoLabel;
    }

    public void createCenterPanel() {
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        centerPanel.add(createLeftZone(), BorderLayout.WEST);
        centerPanel.add(createRightZone(), BorderLayout.EAST);
    }

    public JPanel createRightZone() {
        JPanel searchArea = new JPanel(new GridLayout(2, 1, 0, 5));
        searchArea.setBackground(Color.WHITE);
        JLabel loginLabel = new JLabel("Inicia sesión", SwingConstants.RIGHT);
        loginLabel.setForeground(Color.DARK_GRAY);
        JPanel searchBox = new JPanel(new BorderLayout());
        searchField = new JTextField("Buscar en la entidad", 20);
        JButton searchBtn = new JButton("\uD83D\uDD0D");
        searchBtn.addActionListener(actionSearch());
        searchBtn.setBackground(new Color(0, 51, 102));
        searchBtn.setForeground(Color.WHITE);
        searchBox.add(searchField, BorderLayout.CENTER);
        searchBox.add(searchBtn, BorderLayout.EAST);
        searchArea.add(loginLabel);
        searchArea.add(searchBox);
        return searchArea;
    }

    public void cleanSearchField() {
        searchField.setText("");
    }

    public ActionListener actionSearch() {
        return new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                SearchFrame searchFrame = new SearchFrame(searchField.getText());
                cleanSearchField();
            }
        };
    }

    public void createMenuPanel() {
        menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuPanel.setBackground(new Color(245, 245, 245));
        Color btnMenuColor = new Color(0, 60, 120);
        JButton btnInicio = new MenuBtn("Inicio", btnMenuColor);
        btnInicio.setForeground(Color.WHITE);
        btnMenuColor = new Color(245, 245, 245);
        JButton btnTransparencia = new MenuBtn(
                "<html><center>Transparencia y acceso<br>a la información pública</center></html>", btnMenuColor);
        JButton btnServicios = new MenuBtn("<html><center>Servicios de atención a<br>la ciudadanía v</center></html>",
                btnMenuColor);
        JButton btnParticipa = new MenuBtn("Participa v", btnMenuColor);
        JButton btnNoticias = new MenuBtn("Noticias", btnMenuColor);
        JButton btnNormatividad = new MenuBtn("Normatividad", btnMenuColor);

        menuPanel.add(btnInicio);
        menuPanel.add(btnTransparencia);
        menuPanel.add(btnServicios);
        menuPanel.add(btnParticipa);
        menuPanel.add(btnNoticias);
        menuPanel.add(btnNormatividad);
        menuPanel.add(createMenuButton());
    }

    public JButton createMenuButton() {
        JButton menuButton = new JButton("\u2630");
        menuButton.setFont(new Font("SansSerif", Font.BOLD, 30));
        menuButton.setBackground(new Color(245, 245, 245));
        menuButton.setForeground(Color.DARK_GRAY);
        menuButton.setFocusPainted(false);
        menuButton.setBorder(new EmptyBorder(15, 25, 15, 25));
        menuButton.setContentAreaFilled(true);
        menuButton.setOpaque(true);
        JPopupMenu popupMenu = createPopupMenu();
        menuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menuButton.setBackground(new Color(200, 200, 200));
                popupMenu.show(menuButton, 0, menuButton.getHeight());
                menuButton.setText("\u2716");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuButton.setBackground(new Color(245, 245, 245));
                popupMenu.setVisible(false);
                menuButton.setText("\u2630");
            }
        });
        return menuButton;
    }

    public JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        String[] options = {
                "Documentos", "Infórmate", "Nosotros",
                "Enlaces de Interés", "Transparencia",
                "Compras Públicas Locales de Alimentos",
                "Menú Participa", "Entidades relacionadas"
        };

        for (String option : options) {
            JMenuItem item = new JMenuItem(option + "   >");
            item.setBackground(Color.WHITE);
            item.setFont(new Font("SansSerif", Font.PLAIN, 14));
            item.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220))); // Línea separadora
            popupMenu.add(item);
        }
        return popupMenu;
    }

}
