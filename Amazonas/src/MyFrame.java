import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends  JFrame{
    private ButtonWithIcon button1;
    public MyFrame(){
        super();
        this.setSize(500,500);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        button1 = new ButtonWithIcon("Calendario","#");
        panel.add(button1);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
