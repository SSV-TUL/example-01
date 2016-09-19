package cz.tul.ssv;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Point;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jan-hybs
 */
public class Ball extends JPanel {
    
    private static final Random random = new Random();
    private final int width, height;
    private int speedX, speedY;

    public Ball(int width, int height) {
        this(width,
             height, 
             (random.nextInt(5)+5)*(random.nextInt(2)*2 - 1),
             (random.nextInt(5)+5)*(random.nextInt(2)*2 - 1));
    }

    public Ball(int width, int height, int speedX, int speedY) {
        this.width = width;
        this.height = height;
        this.speedX = speedX;
        this.speedY = speedY;
        
        this.setBackground(Color.red);
        this.setSize(this.width, this.height);
    }
    
    
    
    
    public void update(int width, int height) {
        Point p = this.getLocation();
        int nextX = p.x + speedX;
        int nextY = p.y + speedY;
        
        if(nextX > width-this.width) {
            speedX = -speedX;
            nextX = width-this.width;
        }
        
        if(nextX  < 0) {
            speedX = -speedX;
            nextX = 0;
        }
        
        if(nextY > height-this.height) {
            speedY = -speedY;
            nextY = height-this.height;
        }
        
        if(nextY  < 0) {
            speedY = -speedY;
            nextY = 0;
        }
        this.setLocation(nextX, nextY);
    }
    
}
