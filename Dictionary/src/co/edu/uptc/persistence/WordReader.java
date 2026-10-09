package co.edu.uptc.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uptc.model.Word;

public class WordReader {
    private String path;

    public WordReader(String path) {
        this.path = path;
    }

    public ArrayList<Word> getWords(){
        ArrayList<Word> words = new ArrayList<>();
        String line;
        try(FileReader source = new FileReader(path);
            BufferedReader read = new BufferedReader(source)){
                while((line = read.readLine()) != null){
                    String[] object = line.split(",");
                    ArrayList<String> synonyms = new ArrayList<>();
                    for (int i = 1; i < object.length; i++) {
                        if (object[i]!= null){
                            synonyms.add(object[i]);
                       }    
                    }
                    Word word = new Word(object[0],synonyms);
                    words.add(word);
                }     
        }catch(IOException e){
            e.printStackTrace();
        };
        return words;
    }

}
