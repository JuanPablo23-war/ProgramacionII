package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddWord extends  JDialog{
    private JLabel word;
    private JTextField txtword;
    private JButton addButton, cancelButton;

    public AddWord(MainFrame mainFrame){
        this.setTitle("Agregar palabra");
        this.setSize(400,200);
        initComponets(mainFrame);
        this.setVisible(true);
    }

    public  void initComponets(MainFrame mainFrame){
        this.setLayout(new FlowLayout());
        word = new JLabel("nueva palabra");
        txtword = new JTextField(20);
        addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.createWord(txtword.getText());
                mainFrame.closeAddWord();
            }
            
        });
        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.closeAddWord();
            }
            
        });
        add(word);
        add(txtword);
        add(addButton);
        add(cancelButton);
    }
}
