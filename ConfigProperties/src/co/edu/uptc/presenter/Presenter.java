package co.edu.uptc.presenter;

import java.util.Locale;
import java.util.ResourceBundle;
import co.edu.uptc.model.Calculator;
import co.edu.uptc.view.IOManager;

public class Presenter {
    private Calculator calculator;
    private IOManager ioManager;
    private ResourceBundle messages;

    public Presenter() {
        calculator = new Calculator();
        ioManager = new IOManager();
        messages = ResourceBundle.getBundle("resources/greeting", Locale.getDefault());  
    }

    public void changeLanguage() {
        String[] options = {messages.getString("espanol"),messages.getString("ingles"),messages.getString("frances") };
        int choice = ioManager.showOptionDialog(messages.getString("mensaje_cambiar_idioma"), options);;
        Locale locale = Locale.getDefault();
        switch (choice){
            case 1 -> locale = Locale.ENGLISH;
            case 2 -> locale = Locale.FRENCH;
        }
        messages = ResourceBundle.getBundle("resources/greeting", locale);
    }

    public String[] operations(){
        String[] options = {messages.getString("texto_sumar"),
            messages.getString("texto_restar"), 
            messages.getString("texto_multiplicar"),
            messages.getString("texto_dividir"), 
            messages.getString("texto_cambiar_idioma"),
            messages.getString("texto_salir")};
        return options;
    }

    public void menu() {
        int choice = -1;
        while (choice != 5) {
            String[] options = operations();
            choice = ioManager.showOptionDialog(messages.getString("mensaje_operacion"), options);
            if (choice == 5) {
                break;
            }
            if (choice == 4){
                changeLanguage();
                continue;
            }
            int a = Integer.parseInt(ioManager.showInputDialog(messages.getString("mensaje_ingresar_numero1")));
            int b = Integer.parseInt(ioManager.showInputDialog(messages.getString("mensaje_ingresar_numero2")));
            switch (choice) {
                case 0:
                    ioManager.showMessage(messages.getString("lblRes") + calculator.add(a, b));
                    break;
                case 1:
                    ioManager.showMessage(messages.getString("lblRes") + calculator.subtract(a, b));
                    break;
                case 2:
                    ioManager.showMessage(messages.getString("lblRes") + calculator.multiply(a, b));
                    break;
                case 3:
                    try {
                        ioManager.showMessage(messages.getString("lblRes") + calculator.divide(a, b));
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
