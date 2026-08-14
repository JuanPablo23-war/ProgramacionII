package co.edu.uptc.model;

public class Range {
    private int min;
    private int max;
    private double percentage;

    public Range(int min, int max, double percentage) {
        this.min = min;
        this.max = max;
        this.percentage = percentage;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public double getPercentage() {
        return percentage;
    }

}
