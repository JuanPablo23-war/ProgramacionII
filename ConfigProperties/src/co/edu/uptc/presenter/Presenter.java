package co.edu.uptc.presenter;

import co.edu.uptc.model.Calculator;
import co.edu.uptc.view.IOManager;

public class Presenter {
    private Calculator calculator;
    private IOManager ioManager;

    public Presenter() {
        this.calculator = new Calculator();
        this.ioManager = new IOManager();
    }

    public void menu() {
        String[] options = {"Add", "Subtract", "Multiply", "Divide", "Exit"};
        int choice = -1;

        while (choice != 4) {
            choice = ioManager.showOptionDialog("Elige una operación:", options);
            if (choice == 4) {
                break;
            }
            int a = Integer.parseInt(ioManager.showInputDialog("Ingresar el primer número:"));
            int b = Integer.parseInt(ioManager.showInputDialog("Ingresar el segundo número:"));
            switch (choice) {
                case 0:
                    ioManager.showMessage("Resultado: " + calculator.add(a, b));
                    break;
                case 1:
                    ioManager.showMessage("Resultado: " + calculator.subtract(a, b));
                    break;
                case 2:
                    ioManager.showMessage("Resultado: " + calculator.multiply(a, b));
                    break;
                case 3:
                    try {
                        ioManager.showMessage("Resultado: " + calculator.divide(a, b));
                    } catch (IllegalArgumentException e) {
                        ioManager.showMessage(e.getMessage());
                    }
                    break;
            }
        }
    }

    public void init() {
        menu();

    }
    

}
