package co.edu.uptc.view;

import javax.swing.JOptionPane;

public class IOManager {
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String showInputDialog(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public int showOptionDialog(String message, String[] options) {
        return JOptionPane.showOptionDialog(null, message, "Calculadora", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
}
