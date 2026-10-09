package co.edu.uptc.model;

import java.util.ArrayList;

import co.edu.uptc.persistence.WordReader;

public class Dictionary {
    private Word currentWord;
    private ArrayList<Word> words;

    public Dictionary(){
        words = getDataWords();
    }

    public void createWord(String name){
        words.add(new Word(name));
    }

    public ArrayList<Word> getDataWords(){
        WordReader reader = new WordReader("./data/dictionary.txt");
        return reader.getWords();
    }

    public  ArrayList<String> getSynonym(){
        return currentWord.getSynonyms();
    }

    public boolean findWord(String name){
        boolean exist = false;
        for(Word word : words){
            if (word.getName().equalsIgnoreCase(name)){
                exist = true;
                System.out.println("palabra encontrada");
                currentWord = word;
                break;
            }
        }
        
        return exist;
    }

    public void addSynonym(String word, String synonym){
        for(int i = 0; i <  words.size(); i++){
            if (words.get(i).getName().equalsIgnoreCase(word)){
                words.get(i).setSynonym(synonym);
                break;
            }
        }
    }

}
