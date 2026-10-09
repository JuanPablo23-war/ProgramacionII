package co.edu.uptc.model;

import java.util.ArrayList;

import co.edu.uptc.persistance.DiscountReader;
import co.edu.uptc.persistance.LandReader;
import co.edu.uptc.persistance.RangeReader;
import co.edu.uptc.persistance.StratumReader;

public class TextSimulator {
    private ArrayList<Land> lands;
    private ArrayList<Range> ranges;
    private ArrayList<Discount> discounts;
    private double[] statusPercentages;
    private LandReader landReader;

    public TextSimulator() {
        lands = new ArrayList<>();
        loadLands();
        ranges = new ArrayList<>();
        loadRanges();
        discounts = new ArrayList<>();
        getDiscounts();
        getStratum();
    }

    public void getStratum(){
        StratumReader stratumReader = new StratumReader();
        statusPercentages = stratumReader.readRanges();
    }

    public void getDiscounts() {
        DiscountReader discountReader = new DiscountReader();
        discounts = discountReader.getDiscounts();
    }

    public void loadRanges(){
        RangeReader rangeReader = new RangeReader();
        ranges = rangeReader.readRanges();
    }

    public void loadLands(){
        landReader = new LandReader();
        lands = landReader.land("data/lands.csv");
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

    public Land findLand(String cadastreNumber) {
        Land findLand = null;
        for (Land land : lands) {
            if (land.getCadastreNumber().equals(cadastreNumber)) {
                findLand =  land;
            }
        }
        return findLand;
    }

    public double calculateTax(Land land, boolean[] isDiscounted) {
        double tax = 0;
        if (land.getUse().equalsIgnoreCase("residencial")) {
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
