package io.github.rudynakodach.codeline.Utils;

import java.awt.*;

public class Drawer {
    String name;
    Point position;
    long rotation;
    private boolean isDrawing = true;
    public final Graphics graphics;

    public Drawer(Graphics g) {
        this.graphics = g;
        System.out.println(g);
        position = new Point(0, 0);
    }

    public void moveTo(Point point) {
        if(isDrawing) {
            graphics.drawLine(position.x, position.y, point.x, point.y);
        }

        position = point;
    }

    public void toggleDrawing() {
        isDrawing = !isDrawing;
    }

    public void setDrawing(boolean value) {
        isDrawing = value;
    }
}
