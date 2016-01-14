import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends DrawImage {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private boolean gameOver = false;
    
    public Score() {
        updateScore("");
    }
    
    public void act() {
        if (scorePlayer1+scorePlayer2 == 10 && gameOver == false) {
            gameOver = true;
            getWorld().addObject(new GameOverWindow(scorePlayer1, scorePlayer2), getWorld().getWidth()/2, getWorld().getHeight()/2);
            getWorld().removeObject(getWorld().getObjects(Ball.class).get(0));
            getWorld().removeObject(getWorld().getObjects(Player.class).get(1));
            getWorld().removeObject(getWorld().getObjects(Player.class).get(0));
        }
    }
    
    public void updateScore(String player) {
        if (player.equals("Player1")) {scorePlayer1++;}
        if (player.equals("Player2")) {scorePlayer2++;}
        
        GreenfootImage image = new GreenfootImage(1, 1);
        
        /*----------* draw strings into image *----------*/
        image.setFont(new Font("Arial", Font.BOLD, 40));
        String scoreText = scorePlayer1+"   |   "+scorePlayer2;
        Dimension dim = getTextDimensions(image, scoreText);
        image.scale(dim.width, dim.height);
        image.setColor(new Color(0, 255, 0));
        image.drawString(scoreText, 0, dim.height);
        /*-----------------------------------------------*/
        
        setImage(image);
    }
    
}