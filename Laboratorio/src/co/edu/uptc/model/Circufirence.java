package co.edu.uptc.model;

public class Circufirence {
    private int radius;

    public Circufirence(int radius){
        this.radius = radius;
    }
    public int calculateArea(){
        return (int) (Math.PI * radius * radius);
    }
}
