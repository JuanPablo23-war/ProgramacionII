package co.edu.uptc.view;
import javax.swing.JFrame;

import co.edu.uptc.presenter.Presenter;

import java.awt.FlowLayout;

public class MyFrame extends JFrame {
    private Presenter presenter;

    public MyFrame(Presenter presenter) {
        super();
        this.presenter = presenter;
        this.setLayout(new FlowLayout());
        MyPanel panel = new MyPanel(this);
        this.getContentPane().add(panel);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String[] days(){
        return presenter.days();
    }

    public String[] colors(){
        return presenter.colors();
    }

}
