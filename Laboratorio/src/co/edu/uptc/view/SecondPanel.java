package co.edu.uptc.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class SecondPanel extends JPanel {
    private JLabel lblRadius;
    private JTextField txtRadius;
    private JButton btnCalculate;
    private JLabel lblArea;
    private JLabel lblResult;
    
    public SecondPanel(ActionListener listener){
        initComponents(listener);
    }
    
    private void initComponents(ActionListener listener) {
        lblRadius = new JLabel("Radio: ");
        add(lblRadius);
        txtRadius = new JTextField(5);
        add(txtRadius);
        btnCalculate = new JButton("Calcular area");
        btnCalculate.setActionCommand("areaCircle");
        btnCalculate.addActionListener(listener);
        add(btnCalculate);
        lblArea = new JLabel("Area: ");
        add(lblArea);
        lblResult = new JLabel("");
        add(lblResult);
    }

    public String radius(){
        return txtRadius.getText();
    }

    public void changeResultCircle(String result){
        lblResult.setText(result);
    }

    public void clearRadius(){
        txtRadius.setText("0");
    }
    

}
