package co.edu.uptc.view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CalculatorView extends JFrame  {
    private CalculatorPanel panel;
    private SecondPanel panel2;
    
    public CalculatorView(ActionListener listener){ 
        initComponents(listener);
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void initComponents(ActionListener listener) {
        panel = new CalculatorPanel(listener);
        panel2 = new SecondPanel(listener);
        this.getContentPane().add(panel, "North");
        this.getContentPane().add(panel2, "South");
    }

    public String side() {
        return panel.side();
    }

    public void changeResult(String result){
        panel.changeResult(result);
    }

    public void clear(){
        panel.clear();
    }

    public String radius() {
        return panel2.radius();
    }

    public void changeResultCircle(String result){
        panel2.changeResultCircle(result);
    }

    public void clear2(){
        panel2.clearRadius();
    }

    


    
}
