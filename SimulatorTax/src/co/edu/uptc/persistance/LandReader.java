package co.edu.uptc.persistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uptc.model.Land;

public class LandReader {
    private boolean isRead;
    private int count;
    private int totalLands;
    private int startLine;

    public LandReader(){
        this.isRead = false;
        this.count = 0;
        this.totalLands = sizeDoc();
        this.startLine = 1;
    }

    public ArrayList<Land> land(String filePath) {
        ArrayList<Land> lands = new ArrayList<>();
        try{
            FileReader source = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(source);  
            String line;
            if ((line = reader.readLine()) == null){
                System.out.println("leido"+lands.size());
                isRead = true;
            }
            while ((line = reader.readLine()) != null) {
                count++;
                if (count >= startLine && count <= totalLands){
                    String[] data = line.split(",");
                    if (data[1].equalsIgnoreCase("15001")) {
                        if (data[4].equalsIgnoreCase("A")|| data[4].equalsIgnoreCase("D")|| data[4].equalsIgnoreCase("J")){
                            Land newLand = getInfoLand(data);
                            lands.add(newLand);
                            
                        }else{
                            continue; 
                        }
                    }
                }
                if (lands.size() >= 1000 ){
                    startLine = count;
                    break;
                }   
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

    public int sizeDoc(){
        int size = 0;
         try{
            FileReader source = new FileReader("data/lands.csv");
            BufferedReader reader = new BufferedReader(source);  
            String line;
            while((line = reader.readLine()) != null){
                size++;
            }
            reader.close();

        } catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return size;
    }
    
    public Land getInfoLand(String[] data){
        String address = data[3];
        int area = Integer.parseInt(data[5]);
        int status = createStatus();
        String use ;
        if (data[4].equalsIgnoreCase("J") ) {
            use = "comercial";
        }else{
            use = "residencial";
        }
        String cadastreNumber = data[2];
        double cadastralValue = Double.parseDouble(data[5]) * 1000000;
        Land newLand = new Land(address, area, status, use, cadastreNumber, cadastralValue);
        return newLand;
    }

    public int createStatus(){
        return (int) (Math.random() *6) + 1;
    }

    public boolean getIsRead(){
        return isRead;
    }
}




