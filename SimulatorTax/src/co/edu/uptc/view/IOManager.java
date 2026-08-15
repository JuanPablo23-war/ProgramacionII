package co.edu.uptc.view;

import javax.swing.JOptionPane;

public class IOManager {
    
    public String inputInformation(String message) {
        String data = JOptionPane.showInputDialog(message);
        return data;
    }

    public void showMessage(String message) {
       JOptionPane.showMessageDialog(null, message);
    }

    public int inputOption(String message, String[] options) {
        int option = JOptionPane.showOptionDialog(null, message, "Descuentos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return option;
    }
}
