package co.edu.uptc.presenter;

import co.edu.uptc.view.MyFrame;

public class Presenter {
    private MyFrame myFrame;

    public Presenter(){
        myFrame = new MyFrame(this);
    }

    public String[] days () {
        String[] values = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        return values;
    }

    public String[] colors () {
        String[] values = {"rojo","Negro","verde","amarillo","azul","blanco"};
        return values;
    }

}
