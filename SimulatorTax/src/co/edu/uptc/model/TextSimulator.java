package co.edu.uptc.model;

import java.util.ArrayList;

import co.edu.uptc.persistance.LandReader;
import co.edu.uptc.persistance.RangeReader;

public class TextSimulator {
    private ArrayList<Land> lands;
    private ArrayList<Range> ranges;
    private ArrayList<Discount> discounts;
    private double[] statusPercentages;

    public TextSimulator() {
        lands = new ArrayList<>();
        loadLands();
        ranges = new ArrayList<>();
        discounts = new ArrayList<>();
        statusPercentages = new double[]{0.004,0.0055,0.00675,0.00775,0.0085,0.0105};
    }

    public void loadRanges(){
        RangeReader rangeReader = new RangeReader();
        ranges = rangeReader.readRanges("data/ranges.txt");
    }

    public void loadLands(){
        LandReader landReader = new LandReader();
        lands = landReader.land("data/lands.txt");
    }

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
        if (land.getUse().equals("residencial")) {
            tax = land.getCadastralValue() * statusPercentages[land.getStatus()-1];
        }else {
           for (Range range : ranges) {
                if (land.getCadastralValue() >= range.getMin() && (range.getMax() == -1 || land.getCadastralValue() <= range.getMax())) {
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
