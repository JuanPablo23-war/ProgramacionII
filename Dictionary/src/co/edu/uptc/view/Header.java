package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.presenter.Presenter;

public class Header extends  JPanel {
    private  JLabel word;
    private JTextField txtword;
    private JButton findSynonyms;


    public Header(MainFrame mainFrame){
        initComponets(mainFrame);
    }

    public void initComponets(MainFrame mainFrame){
        createComponets();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(word, gbc);
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        add(txtword, gbc);
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(findSynonyms , gbc);
        addActionListenerToButton(mainFrame);
    }

    public void createComponets(){
        word = new JLabel("word :");
        txtword = new JTextField(30);
        findSynonyms = new JButton("Find Synonyms");
    }

    public void addActionListenerToButton(MainFrame mainFrame){
        findSynonyms.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String word = txtword.getText();
                if (word.isEmpty()){
                    JOptionPane.showInputDialog(  "Please enter a word");
                } else {
                    if (mainFrame.searchWord(word)){
                        mainFrame.getSynonyms();
                    } else {
                        JOptionPane.showMessageDialog( null, "The word does not exist in the dictionary.");
                    } 
                }
            }
        }
        );
    }

}
