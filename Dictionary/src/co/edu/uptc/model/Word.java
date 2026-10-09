package co.edu.uptc.model;

import java.util.ArrayList;

public class Word {
    private String name;
    private ArrayList<String> synonyms;

    public Word (String name){
        this.name = name;
    }

    public Word (String name, ArrayList<String> synonyms){
        this.name = name;
        this.synonyms = synonyms;
    }
    
    public void setSynonym(String synonym){
        synonyms.add(synonym);
    }

    public  String getName(){
        return  name;
    }

    public  ArrayList<String> getSynonyms(){
        return synonyms;
    }

    public int getSynonymLengh(){
        return synonyms.size();

    }

}
