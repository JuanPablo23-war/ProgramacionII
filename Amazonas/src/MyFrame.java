import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends  JFrame{
    private ButtonWithIcon button1;
    private HeaderPanel headerPanel;
    public MyFrame(){
        super();
        this.setSize(1200, 250);
        this.setLayout(new BorderLayout());
        headerPanel = new HeaderPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        button1 = new ButtonWithIcon("Calendario","#");
        add(headerPanel, BorderLayout.NORTH);
        panel.add(button1);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
