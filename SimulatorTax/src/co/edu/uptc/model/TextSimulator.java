package co.edu.uptc.model;

import java.util.ArrayList;

public class TextSimulator {
    private ArrayList<Land> lands;
    private ArrayList<Range> ranges;
    private ArrayList<Discount> discounts;
    private double[] statusPercentages;

    public void addLand(Land land) {
        lands.add(land);
    }

    public void addRange(Range range) {
        ranges.add(range);
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public Land findLand(int cadastreNumber) {
        Land findLand = null;
        for (Land land : lands) {
            if (land.getCadastreNumber() == cadastreNumber) {
                findLand = land;
            }
        }
        return findLand;
    }

    public double calculateTax(Land land, boolean[] isDiscounted) {
        double tax = 0;
        if (land.getUse().equals("residential")) {
            tax = land.getCadastralValue() * statusPercentages[land.getStatus()-1];
        }else {
           for (Range range : ranges) {
                if (land.getCadastralValue() >= range.getMin() && land.getCadastralValue() <= range.getMax()) {
                    tax = land.getCadastralValue() * range.getPercentage();
                    break;
                }
            }

           } 
        if (isDiscounted[0]) {
            tax -= tax * discounts.get(0).getPercentage();
        }
        if (isDiscounted[1]) {
            tax -= tax * discounts.get(1).getPercentage();
        }
        return tax;
    }
}
