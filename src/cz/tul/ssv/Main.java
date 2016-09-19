package cz.tul.ssv;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class Main extends JFrame {

    public final int FPS = 30;
    public final int ITEM_COUNT = 500;
    public List<Ball> items = new ArrayList<>();
    
    public static void main(String[] args) {
        new Main();
    }

    public Main() throws HeadlessException {
        this.setTitle("Foo bar");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setPreferredSize(new Dimension(800, 600));
        
        
        for (int i = 0; i < ITEM_COUNT; i++) {
            Ball ball = new Ball(5, 5);
            ball.setLocation(new Random().nextInt(800), new Random().nextInt(600));
            this.getContentPane().add(ball);
            this.items.add(ball);
        }
        
        
        
        this.setLayout(null);
        this.pack();
        this.setVisible(true);
        
        
        while (true) {            
            this.repaint();
            
            try {
                Thread.currentThread().sleep(1000/FPS);
            } catch (InterruptedException ex) {
                
            }
        }
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = this.getSize();
        for (Ball ball : items) {
            ball.update(size.width, size.height-30);
        }
    }

}
