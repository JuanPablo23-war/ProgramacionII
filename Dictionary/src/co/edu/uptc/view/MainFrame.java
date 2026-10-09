package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import co.edu.uptc.presenter.Presenter;

public class MainFrame extends JFrame {
    private Header header;
    private Body body;
    private Footer footer;
    private Presenter presenter;

    public MainFrame (Presenter presenter){
        super("Diccionario");
        this.presenter = presenter;
        this.setLayout(new BorderLayout());
        initPanel();
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initPanel(){
        header = new Header(this);
        this.getContentPane().add(BorderLayout.NORTH,header );
        body = new Body();
        body.setBorder(BorderFactory.createTitledBorder("Synonyms"));
        this.getContentPane().add(body, BorderLayout.CENTER);
        footer = new Footer(this);
        this.getContentPane().add(footer, BorderLayout.SOUTH);
    }

    public void setSynonymsBody(ArrayList<String> synonyms){
        body.setSynonyms(synonyms);
    }

    public void closeAddSynonym(){
        footer.closeAddSynonym();
    }

    public void createSynonym(String word, String synonym){
        presenter.createSynonym(word, synonym);
    }

    public boolean searchWord(String word){
        return presenter.searchWord(word);
    }

    public void getSynonyms(){
        presenter.getSynonyms();
    }

    public void createWord(String name){
        presenter.createWord(name);
    }

    public void closeAddWord(){
        footer.closeAddWord();
    }

}
