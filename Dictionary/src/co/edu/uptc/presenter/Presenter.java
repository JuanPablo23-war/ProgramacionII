package co.edu.uptc.presenter;

import co.edu.uptc.model.Dictionary;
import co.edu.uptc.view.MainFrame;

public class Presenter {
    Dictionary dictionary;
    MainFrame frame;

    public Presenter(){
        dictionary = new Dictionary();
        frame = new MainFrame(this);
    }

    public boolean searchWord(String name){
        boolean exist = dictionary.findWord(name);
        return exist;
    }

    public void getSynonyms(){
        frame.setSynonymsBody(dictionary.getSynonym());
    }

    public void createSynonym(String word, String Synonym){
        dictionary.addSynonym(word, Synonym);
    }

    public void createWord(String name){
        dictionary.createWord(name);
    }

    

}
