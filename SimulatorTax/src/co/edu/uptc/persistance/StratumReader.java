package co.edu.uptc.persistance;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class StratumReader {
    public double[] readRanges() {
        Properties p = new Properties();
        double [] stratums = new double[6];
        try {
            p.load(new FileReader("config.properties"));
            String line = p.getProperty("stratus");
            String[] data = line.split(",");
            stratums[0] = Double.parseDouble(data[0]);
            stratums[1] = Double.parseDouble(data[1]);
            stratums[2] = Double.parseDouble(data[2]);
            stratums[3] = Double.parseDouble(data[3]);
            stratums[4] = Double.parseDouble(data[4]);
            stratums[5] = Double.parseDouble(data[5]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stratums;
    }

}
