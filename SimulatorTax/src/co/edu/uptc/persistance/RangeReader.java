package co.edu.uptc.persistance;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import co.edu.uptc.model.Range;

public class RangeReader {
    public ArrayList<Range> readRanges() {
        ArrayList<Range> ranges = new ArrayList<>();
        Properties p = new Properties();
        try {
            p.load(new FileReader("config.properties"));
            for (int i = 1;i<=6; i++){
                String line = p.getProperty("range_"+ i);
                String[] data = line.split(",");
                ranges.add(new Range(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Double.parseDouble(data[2])))  ; 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ranges;
    }

}
