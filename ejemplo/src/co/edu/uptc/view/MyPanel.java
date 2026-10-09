package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class MyPanel extends JPanel {
    private JButton button1, button2;
    private JComboBox combo1;

    public MyPanel(MyFrame myFrame) {
        initComponents(myFrame);
    }

    public void initComponents(MyFrame myFrame) {
        this.setLayout(new FlowLayout());
        button1 = new JButton("dias");
        button1.setBorderPainted(false);
        button1.setForeground(Color.WHITE);
        button1.setPreferredSize(new Dimension(100, 100));
        button1.setUI(new ShapedButtonUI());
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] values = myFrame.days();
                DefaultComboBoxModel model = new DefaultComboBoxModel(values);
                combo1.setModel(model);
            }

        });
        button2 = new JButton("Color");
        button2.setForeground(Color.WHITE);
        button2.setBorderPainted(false);
        button2.setPreferredSize(new Dimension(100, 100));
        button2.setUI(new ShapedButton2UI());
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] values = myFrame.colors();
                DefaultComboBoxModel model = new DefaultComboBoxModel(values);
                combo1.setModel(model);
            }

        });
        combo1 = new JComboBox();
        add(button1);
        add(button2);
        add(combo1);
    }

}
