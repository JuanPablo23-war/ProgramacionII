package co.edu.uptc.persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uptc.model.Land;

public class LandReader {
    public ArrayList<Land> land(String filePath) {
        ArrayList<Land> lands = new ArrayList<>();
        try{
            FileReader source = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(source);  
            String line;

        
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String address = data[0];
                int area = Integer.parseInt(data[1]);
                int status = Integer.parseInt(data[2]);
                String use = data[3];
                int cadastreNumber = Integer.parseInt(data[4]);
                double cadastralValue = Double.parseDouble(data[5]);
                Land land = new Land(address, area, status, use, cadastreNumber, cadastralValue);
                lands.add(land);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
        return lands;
       

    }

}
