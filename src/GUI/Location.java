package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Location extends JButton {
    int x;
    int y;
    Dimension size;
    Color color;

    Location(int x, int y, String text,Color color) {
        super(text);
        this.x = x-15;
        this.y = y-15;
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.height, size.width);
        setPreferredSize(size);
        setContentAreaFilled(false); // Make the button transparent
        setBorderPainted(false); // Remove the default button border
        this.color=color;

    }


    protected void paintComponent(Graphics g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.fillOval(1, 1, getSize().width-2, getSize().height-2);

    }
    protected void paintBorder(Graphics g){
        g.setColor(Color.lightGray);
        g.drawOval(0, 0, getSize().width-1, getSize().height-1);

    }
    Shape shape;
    public boolean isContains(int x, int y){
        if(shape==null || !shape.getBounds().equals(getBounds()))
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return shape.contains(x, y);


    }
    public static int LocationConvertor(String location,String[] names)
    {
        for (int i = 0; i < names.length; i++)
        {
            if(location.equals(names[i]))
            {
                return i;
            }
        }
        return -1;
    }
}
