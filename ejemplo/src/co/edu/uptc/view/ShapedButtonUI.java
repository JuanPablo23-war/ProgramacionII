package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class ShapedButtonUI extends BasicButtonUI {
	 @Override
	    public void paint(Graphics g, JComponent c) {
	        Graphics2D g2d = (Graphics2D) g;
	        Shape buttonShape = null;
	        buttonShape = new Ellipse2D.Double(0, 0, c.getWidth(), c.getHeight());
	        g2d.setPaint(Color.BLUE);
	        g2d.fill(buttonShape);
	        super.paint(g2d, c);
	    }

}
