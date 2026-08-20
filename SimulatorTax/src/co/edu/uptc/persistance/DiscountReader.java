package co.edu.uptc.persistance;

import java.util.ArrayList;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

import co.edu.uptc.model.Discount;

public class DiscountReader {
    public ArrayList<Discount> getDiscounts() {
        ArrayList<Discount> discounts = new ArrayList<>();
        Properties p = new Properties();
        try {
            p.load(new FileReader("config.properties"));
            double earlyPayment = Double.parseDouble(p.getProperty("early_payment"));
            double exemptLand = Double.parseDouble(p.getProperty("exempt_land"));
            discounts.add(new Discount("pronto pago", earlyPayment));
            discounts.add(new Discount("terreno exento", exemptLand));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return discounts;
    }

}
