package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.model.Circufirence;
import co.edu.uptc.model.Square;
import co.edu.uptc.view.CalculatorView;

public class Presenter implements ActionListener{
    private CalculatorView view;
    private Square square;
    private Circufirence circufirence;

    public Presenter(){
        view = new CalculatorView(this);
    }
    @Override 
    public void actionPerformed(ActionEvent event) {
        String source = event.getActionCommand();
        if (source.equals("calculate")) {
            square = new
            Square(Integer.parseInt(view.side()));
            view.changeResult(String.valueOf(square.calculateArea()));
            view.clear();
        }
        if (source.equals("areaCircle")) {
            circufirence = new Circufirence(Integer.parseInt(view.radius()));
            view.changeResultCircle(String.valueOf(circufirence.calculateArea()));
            view.clear2();
        }
    }


}
