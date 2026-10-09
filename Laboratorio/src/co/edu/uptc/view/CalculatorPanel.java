package co.edu.uptc.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorPanel extends  JPanel {
    private JLabel lblSide;
    private JTextField txtSide;
    private JButton btnCalculate;
    private JLabel lblArea;
    private JLabel lblResult;

    public CalculatorPanel(ActionListener listener){
        initComponents(listener);
    }
    private void initComponents(ActionListener listener) {
        lblSide = new JLabel("Lado: ");
        add(lblSide);
        txtSide = new JTextField(5);
        add(txtSide);
        btnCalculate = new JButton("Calcular area");
        btnCalculate.setActionCommand("calculate");
        btnCalculate.addActionListener(listener);
        add(btnCalculate);
        lblArea = new JLabel("Area: ");
        add(lblArea);
        lblResult = new JLabel("");
        add(lblResult);
    }

    public String side(){
        return txtSide.getText();
    }

    public void changeResult(String result){
        lblResult.setText(result);
    }

    public void clear(){
        txtSide.setText("0");
    }

}
