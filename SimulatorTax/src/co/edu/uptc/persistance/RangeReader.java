package co.edu.uptc.persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uptc.model.Range;

public class RangeReader {

    public ArrayList<Range> readRanges(String filePath) {
        ArrayList<Range> ranges = new ArrayList<>();
        try{
            FileReader source = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(source);  
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int min = Integer.parseInt(data[0]);
                int max = Integer.parseInt(data[1]);
                double percentage = Double.parseDouble(data[2]);
                Range range = new Range(min, max, percentage);
                ranges.add(range);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
        return ranges;
    }
}
