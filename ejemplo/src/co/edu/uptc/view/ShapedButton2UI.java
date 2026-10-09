package co.edu.uptc.view;

import java.awt.*;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;


public class ShapedButton2UI extends BasicButtonUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        int width = c.getWidth();
        int height = c.getHeight();
 
        Shape buttonShape = null;
        int[] pointsX = {width/2,width - 1,0};
        int[] pointsY = {0,height - 1,height-1};
        int numberOfPoints = 3;
        buttonShape = new Polygon(pointsX,pointsY,numberOfPoints);
        g2d.setPaint(Color.RED);
        g2d.fill(buttonShape);
        super.paint(g2d, c);
    }
}
