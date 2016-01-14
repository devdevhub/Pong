import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class GameOverWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWindow extends DrawImage {
    
    private int scorePlayer1;
    private int scorePlayer2;
    private GreenfootImage image = new GreenfootImage(800, 200);
    
    public GameOverWindow(int scorePlayer1, int scorePlayer2) {
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
        updateGameOverWindow();
    }
    
    public void updateGameOverWindow() {
        /*----------* draw strings into image *----------*/
        image.setFont(new Font("Arial", Font.BOLD, 42));
        String text1 = "";
        if (scorePlayer1 > scorePlayer2) {text1 = "Player 1 wins this round.";}
        if (scorePlayer1 < scorePlayer2) {text1 = "Player 2 wins this round.";}
        if (scorePlayer1 == scorePlayer2) {text1 = "It's a tie.";}
        Dimension dim1 = getTextDimensions(image, text1);
        image.setColor(new Color(0, 255, 0));
        image.drawString(text1, image.getWidth()/2-(int)(dim1.getWidth()/2), image.getHeight()/2-(int)(dim1.getHeight()/2));
        
        image.setFont(new Font("Arial", Font.BOLD, 28));
        String text2 = "Play again?";
        Dimension dim2 = getTextDimensions(image, text2);
        image.setColor(new Color(0, 255, 0));
        image.drawString(text2, image.getWidth()/2-(int)(dim2.getWidth()/2), image.getHeight()/2+(int)(dim2.getHeight()/2));
        /*-----------------------------------------------*/
        
        setImage(image);
    }
    
}