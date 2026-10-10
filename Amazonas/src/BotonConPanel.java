
import javax.swing.*;
import java.awt.*;


public class BotonConPanel extends JPanel {
    private JButton cardButton;
    private JPanel internalPanel;
    private JLabel text, labelImage;

    public BotonConPanel(String fileRoute) {
        cardButton = new JButton();
        cardButton.setLayout(new BorderLayout());
        cardButton.setPreferredSize(new Dimension(120, 280));
        cardButton.setMargin(new Insets(10, 10, 10, 10));
        internalPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        internalPanel.setOpaque(false);
        text = new JLabel("Producto Premium", SwingConstants.LEFT);
        text.setFont(new Font("Arial", Font.BOLD, 16));

        labelImage = new JLabel();
        try {
            ImageIcon iconOriginal = new ImageIcon(fileRoute);
            Image imageRelazed = iconOriginal.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            labelImage.setIcon(new ImageIcon(imageRelazed));
        } catch (Exception e) {
            labelImage.setText("[Imagen]");
        }

        internalPanel.add(labelImage);
        internalPanel.add(text);
        cardButton.add(internalPanel, BorderLayout.CENTER);
        cardButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Seleccionaste el producto.");
        });
    }
}
