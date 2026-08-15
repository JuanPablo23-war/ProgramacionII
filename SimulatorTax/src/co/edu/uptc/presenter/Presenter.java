package co.edu.uptc.presenter;

import co.edu.uptc.model.Discount;
import co.edu.uptc.model.Land;
import co.edu.uptc.model.Range;
import co.edu.uptc.model.TextSimulator;
import co.edu.uptc.view.IOManager;

public class Presenter {
    private IOManager ioManager;
    private TextSimulator textSimulator;

    public Presenter() {
        ioManager = new IOManager();
        textSimulator = new TextSimulator();
    }

    public String menu() {
        String menu = "1. Add Land\n";
        menu += "2. Add Range\n";
        menu += "3. Add Discount\n";
        menu += "4. Calculate Tax\n";
        menu += "5. Exit\n";
        return menu;
    }

    public void calculateTax(){
        String[] options = {"Yes", "No"};
        int cadastreNumber = Integer.parseInt(ioManager.inputInformation("Numero de catastro: "));
        Land land = textSimulator.findLand(cadastreNumber);
        if (land != null) {
            boolean[] isDiscounted = new boolean[2];
            isDiscounted[0] = ioManager.inputOption("¿Aplica descuento por pronto pago? (si/no)", options) == 0;
            isDiscounted[1] = ioManager.inputOption("¿El predio es exento? (si/no)", options) == 0;
            double tax = textSimulator.calculateTax(land, isDiscounted);
            ioManager.showMessage("El impuesto a pagar es: " + tax);
        } else {
            ioManager.showMessage("No se encontró un terreno con el número de catastro proporcionado.");
        }
    }

    public void addLand() {
        int area = Integer.parseInt(ioManager.inputInformation("Ingrese el área del terreno: "));
        int cadastreNumber = Integer.parseInt(ioManager.inputInformation("Ingrese el número de catastro: "));
        double cadastralValue = Double.parseDouble(ioManager.inputInformation("Ingrese el valor catastral: "));
        String use = ioManager.inputInformation("Ingrese el uso del terreno (residencial, comercial): ");
        int status = Integer.parseInt(ioManager.inputInformation("Ingrese el estrato del terreno (1-6): "));
        Land land = new Land(area, status, use, cadastreNumber, cadastralValue);
        textSimulator.addLand(land);
    }

    public void addRange() {
        int min = Integer.parseInt(ioManager.inputInformation("Ingrese el valor mínimo del rango: "));
        int max = Integer.parseInt(ioManager.inputInformation("Ingrese el valor máximo del rango: "));
        double percentage = Double.parseDouble(ioManager.inputInformation("Ingrese el porcentaje de impuesto para este rango (en decimal): "));
        textSimulator.addRange(new Range(min, max, percentage));
    }

    public void addDiscount() {
        String discountType = ioManager.inputInformation("Ingrese el tipo de descuento: ");    
        double percentage = Double.parseDouble(ioManager.inputInformation("Ingrese el porcentaje de descuento (en decimal): "));
        textSimulator.addDiscount(new Discount(discountType, percentage));
    }

    public void init() {
        String option;
        do {
            option = ioManager.inputInformation(menu());
            switch (option) {
                case "1":
                    addLand();
                    break;
                case "2":
                    addRange();
                    break;
                case "3":
                    addDiscount();
                    break;
                case "4":
                    calculateTax();
                    break;
                case "5":
                    ioManager.showMessage("Saliendo del programa...");
                    break;
                default:
                    ioManager.showMessage("Opción inválida. Intente nuevamente.");
            }
        } while (!option.equals("5"));
        
    }

}
