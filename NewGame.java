import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class NewGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewGame extends DrawImage {
    
    private GreenfootImage image = new GreenfootImage(800, 200);
    private int alpha = 255;
    
    public NewGame() {
        drawText();
    }
    
    /**
     * Act - do whatever the NewGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        alpha -= 5;
        if (alpha >= 0) {
            drawText(alpha);
        }
        if (alpha < 0) {
            spawnObjects();
            getWorld().removeObject(this);
        }
    }
    
    public void drawText() {
        /*----------* draw strings into image *----------*/
        image.setFont(new Font("Arial", Font.BOLD, 112));
        String text = "PONG";
        Dimension dim = getTextDimensions(image, text);
        image.setColor(new Color(0, 255, 0));
        image.drawString(text, image.getWidth()/2-(int)(dim.getWidth()/2), image.getHeight()/2+(int)(dim.getHeight()/2));
        /*-----------------------------------------------*/
        
        setImage(image);
    }
    
    public void drawText(int alpha) {
        image.clear();
        
        /*----------* draw strings into image *----------*/
        image.setFont(new Font("Arial", Font.BOLD, 48));
        String text = "NEW GAME";
        Dimension dim = getTextDimensions(image, text);
        image.setColor(new Color(0, 255, 0, alpha));
        image.drawString(text, image.getWidth()/2-(int)(dim.getWidth()/2), image.getHeight()/2+(int)(dim.getHeight()/2));
        /*-----------------------------------------------*/
        
        setImage(image);
    }
    
    public void spawnObjects() {
        getWorld().addObject(new Ball(), getWorld().getWidth()/2, getWorld().getHeight()/2);
        getWorld().addObject(new Player1(), 8, getWorld().getHeight()/2);
        getWorld().addObject(new Player2(), getWorld().getWidth()-8, getWorld().getHeight()/2);
        getWorld().addObject(new Score(), getWorld().getWidth()/2, 25);
        
        getWorld().setPaintOrder(
            Ball.class, Player1.class, Player2.class,
            Score.class
        );
    }
    
}