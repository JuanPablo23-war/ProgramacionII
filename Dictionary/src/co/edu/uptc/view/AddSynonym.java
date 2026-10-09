package co.edu.uptc.view;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddSynonym extends JDialog{
    private JLabel word,synonym;
    private JTextField txtword,txtsynonym;
    private JButton addButton, cancelButton;

    public AddSynonym (MainFrame mainFrame){
        this.setTitle("Agregar un Sinonimo");
        this.setSize(200, 200);
        initComponents(mainFrame);
        this.pack();
        this.setVisible(true);
    }

    public void initComponents(MainFrame mainFrame){
        this.setLayout(new GridLayout(3,2));
        word = new JLabel("Palabra: ");
        txtword = new JTextField(20);
        synonym = new JLabel("Sinonimo: ");
        txtsynonym = new JTextField(20);
        addButton = new JButton("Agregar Sinonimo");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.createSynonym(txtword.getText(), txtsynonym.getText());
                mainFrame.closeAddSynonym();
            }  
        });
        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.closeAddSynonym();
            }
            
        });
        add(word);
        add(txtword);
        add(synonym);
        add(txtsynonym);
        add(addButton);
        add(cancelButton);
       
    }

}
