package co.edu.uptc.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

public class Footer extends JPanel {
    private JButton addSynonym, addWord;
    private AddSynonym addSynonymDialog;
    private AddWord addWordDialog;


    public Footer(MainFrame mainFrame){
        initComponets(mainFrame);
    }

    public void initComponets(MainFrame mainFrame){
        createComponets(mainFrame);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(addSynonym, gbc);
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        add(addWord, gbc);
    }

    public void createComponets(MainFrame mainFrame){
        addSynonym = new JButton("Add Synonym");
        addActionListenerSynonym(mainFrame);
        addWord = new JButton("Add Word");
        addActionListenerWord(mainFrame);
    }

    public void addActionListenerSynonym(MainFrame mainFrame){
        addSynonym.addActionListener( new ActionListener() {
            @Override 
            public  void actionPerformed(java.awt.event.ActionEvent e){
                addSynonymDialog = new AddSynonym(mainFrame);
            }
        });
    }

    public void addActionListenerWord(MainFrame mainFrame){
        addWord.addActionListener( new ActionListener() {
            @Override 
            public  void actionPerformed(java.awt.event.ActionEvent e){
                addWordDialog = new AddWord(mainFrame);
            }
        });
    }

    public void closeAddSynonym(){
        if (addSynonymDialog != null) {
            addSynonymDialog.dispose();
            addSynonymDialog = null;
        }
    }

    public void closeAddWord(){
        addWordDialog.dispose();
    }


}
