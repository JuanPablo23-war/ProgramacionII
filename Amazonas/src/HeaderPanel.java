import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HeaderPanel extends  JPanel {
    private JPanel topPanel,centerPanel, menuPanel;
    public HeaderPanel(){
        createTopPanel();
        createCenterPanel();
        createMenuPanel();
        add(topPanel);
        add(centerPanel);
        add(menuPanel);
    }

    public void createTopPanel(){
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(new Color(0, 51, 160));
        JLabel govLabel = new JLabel("gov.co");
        govLabel.setForeground(Color.WHITE);
        govLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        topPanel.add(govLabel);
    }

    public void createCenterPanel(){
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        // Zona Izquierda: Logo y Título
        JPanel titleArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titleArea.setBackground(Color.WHITE);
        // Placeholder para el logo redondo
        JLabel logoLabel = new JLabel(new ImageIcon("ruta_al_logo.png")); 
        JLabel titleLabel = new JLabel(" | Gobernación del Amazonas");
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
        titleLabel.setForeground(new Color(50, 50, 50));
        titleArea.add(logoLabel);
        titleArea.add(titleLabel);

        // Zona Derecha: Iniciar sesión y Buscador
        JPanel searchArea = new JPanel(new GridLayout(2, 1, 0, 5));
        searchArea.setBackground(Color.WHITE);
        
        JLabel loginLabel = new JLabel("Inicia sesión", SwingConstants.RIGHT);
        loginLabel.setForeground(Color.DARK_GRAY);
        
        JPanel searchBox = new JPanel(new BorderLayout());
        JTextField searchField = new JTextField("Buscar en la entidad", 20);
        JButton searchBtn = new JButton("Q"); // Placeholder de lupa
        searchBtn.setBackground(new Color(0, 51, 102));
        searchBtn.setForeground(Color.WHITE);
        searchBox.add(searchField, BorderLayout.CENTER);
        searchBox.add(searchBtn, BorderLayout.EAST);
        
        searchArea.add(loginLabel);
        searchArea.add(searchBox);

        centerPanel.add(titleArea, BorderLayout.WEST);
        centerPanel.add(searchArea, BorderLayout.EAST);
    }

    public void createMenuPanel(){
        menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuPanel.setBackground(new Color(245, 245, 245)); 
        Color btnMenuColor = new Color(0, 60, 120);
        // Botón "Inicio" activo
        JButton btnInicio = new MenuBtn("Inicio", btnMenuColor);
        btnInicio.setForeground(Color.WHITE);
        btnMenuColor = new Color(245, 245, 245);
        // Resto de botones
        JButton btnTransparencia = new MenuBtn("<html><center>Transparencia y acceso<br>a la información pública</center></html>", btnMenuColor);
        JButton btnServicios = new MenuBtn("<html><center>Servicios de atención a<br>la ciudadanía v</center></html>", btnMenuColor);
        JButton btnParticipa = new MenuBtn("Participa v", btnMenuColor);
        JButton btnNoticias = new MenuBtn("Noticias", btnMenuColor);
        JButton btnNormatividad = new MenuBtn("Normatividad", btnMenuColor);

        menuPanel.add(btnInicio);
        menuPanel.add(btnTransparencia);
        menuPanel.add(btnServicios);
        menuPanel.add(btnParticipa);
        menuPanel.add(btnNoticias);
        menuPanel.add(btnNormatividad);
    }
    
}
