package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Body extends  JPanel{
    private  JLabel numberSynonyms, synonym;
    private JButton right, left;
    private ArrayList<String> synonyms;
    private int position = 0;

    public Body (){
        initComponets();
    }

    public void initComponets(){
        createComponets();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(left , gbc);
        addActionListenerLeft();
        gbc.weightx = 0.8;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.BOTH;
        add(synonym , gbc);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(right , gbc);
        addActionListenerRight();
        gbc.gridy= 1;
        gbc.weightx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(numberSynonyms , gbc);
    }

    public void createComponets(){
        synonym = new JLabel("");
        synonym.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        synonym.setOpaque(true);
        numberSynonyms = new JLabel("Synonyms number: ");
        right = new JButton(">>");
        left = new JButton("<<");
    }

    public void setSynonyms(ArrayList<String> synonyms){
        this.synonyms = synonyms;
        position = 0;
        if (synonyms != null && !synonyms.isEmpty()) {
            synonym.setText(synonyms.get(0));
            numberSynonyms.setText("Synonyms number: " + synonyms.size());
        }else{

        }
    }

    public void addActionListenerRight(){
        right.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(java.awt.event.ActionEvent e){
                if(position < synonyms.size()-1 && synonyms != null){
                    position += 1;
                    synonym.setText(synonyms.get(position));
                }
            }
        });
    }

    public void addActionListenerLeft(){
        left.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(java.awt.event.ActionEvent e){
                if( position > 0 && synonyms != null){
                    position -= 1;
                    synonym.setText(synonyms.get(position));
                }
            }
        });
    }

}
